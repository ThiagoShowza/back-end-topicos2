package org.acme.service.Pagamento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.Pagamento.PagamentoDTO;
import org.acme.dto.PagamentoResponseDTO;
import org.acme.dto.Pedido.PedidoResponseDTO;
import org.acme.model.Pagamento;
import org.acme.model.Pedido;
import org.acme.model.StatusPagamento;
import org.acme.repository.PagamentoRespository;
import org.acme.repository.PedidoRepository;
import org.acme.service.PagamentoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    PagamentoRespository pagamentoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PagamentoResponseDTO insert(PagamentoDTO dto) {
        // Buscar o pagamento pelo ID do pedido
        Pagamento pagamentoExistente = pagamentoRepository.findByPedidoId(dto.idPedido());
        if (pagamentoExistente == null) {
            throw new IllegalStateException("Não existe um pagamento pendente para o pedido fornecido.");
        }

        // Atualizar o método de pagamento
        pagamentoExistente.setMetodo(dto.metodo());
        pagamentoExistente.setStatus(StatusPagamento.APROVADO);
        // Persistir a atualização do pagamento
        pagamentoRepository.persist(pagamentoExistente);

        // Retornar o DTO do pagamento atualizado
        return PagamentoResponseDTO.valueOf(pagamentoExistente, pagamentoExistente.getPedido());
    }


    private double calcularValorTotal(Pedido pedido) {
        return pedido.getItens().stream()
                .mapToDouble(item -> item.getQuantidade() * item.getJoia().getPreco())
                .sum();
    }
    @Override
    @Transactional
    public PagamentoResponseDTO update(PagamentoDTO dto, Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento == null) {
            throw new IllegalArgumentException("Pagamento não encontrado");
        }

        Pedido pedido = pedidoRepository.findById(dto.idPedido());
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        double valorTotal = calcularValorTotal(pedido);
        pagamento.setMetodo(dto.metodo());
        pagamento.setPedido(pedido);
        pagamento.setValorTotal(valorTotal);
        pagamento.setDataPagamento(LocalDate.now());

        pagamentoRepository.persist(pagamento);

        return PagamentoResponseDTO.valueOf(pagamento, pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento == null) {
            throw new IllegalArgumentException("Pagamento não encontrado");
        }
        pagamentoRepository.delete(pagamento);
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento == null) {
            throw new IllegalArgumentException("Pagamento não encontrado");
        }
        Pedido pedido = pagamento.getPedido();
        return PagamentoResponseDTO.valueOf(pagamento, pedido);
    }

    @Override
    public List<PagamentoResponseDTO> findByNome(String nome) {
        List<Pagamento> pagamentos = pagamentoRepository.find("pedido.pessoa.nome", nome).list();
        return pagamentos.stream()
                .map(pagamento -> PagamentoResponseDTO.valueOf(pagamento, pagamento.getPedido()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PagamentoResponseDTO> findByAll() {
        return pagamentoRepository.listAll().stream()
                .map(pagamento -> PagamentoResponseDTO.valueOf(pagamento, pagamento.getPedido()))
                .collect(Collectors.toList());
    }

}
