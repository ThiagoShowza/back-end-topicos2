package org.acme.service.ItemPedido;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.acme.dto.ItemPedido.ItemPedidoDTO;
import org.acme.dto.ItemPedido.ItemPedidoResponseDTO;
import org.acme.dto.Joia.JoiaResponseDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.model.*;
import jakarta.inject.Inject;
import org.acme.repository.*;
import org.acme.service.Auth.AuthService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ItemPedidoServiceImpl implements ItemPedidoService {
    @Inject
    JsonWebToken jwt;

    @Inject
    AuthService authService;

    @Inject
    ItemPedidoRepository itemPedidoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    JoiaRepository joiaRepository;

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    PagamentoRespository pagamentoRepository;

    @Override
    @Transactional
    public ItemPedidoResponseDTO insert(ItemPedidoDTO dto) {
        String email = jwt.getSubject();
        Log.info("Pegando o usuário logado email: " + email);

        LoginResponseDTO usuarioDTO = authService.findByEmail(email);
        if (usuarioDTO == null) {
            throw new EntityNotFoundException("Usuário não encontrado com o email: " + email);
        }

        // Obter todos os itens de pedido associados ao usuário
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByPessoaId(usuarioDTO.pessoa().id());

        Pedido pedido = null;

        // Verificar se já existe um pedido com itens
        if (!itemPedidos.isEmpty()) {
            pedido = itemPedidos.get(0).getPedido();
        }

        // Se não houver um pedido com itens, criar um novo pedido
        if (pedido == null) {
            pedido = new Pedido();
            Pessoa cliente = pessoaRepository.findById(usuarioDTO.pessoa().id());
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não encontrado");
            }
            pedido.setPessoa(cliente);
            pedidoRepository.persist(pedido);
        }

        // Criar um novo ItemPedido
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(dto.quantidade());
        itemPedido.setTipoPedido(dto.tipoPedido());
        itemPedido.setPedido(pedido);

        Joia produto = joiaRepository.findById(dto.idPedido());
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        itemPedido.setJoia(produto);

        // Associar o item ao pedido
        if (pedido.getItens() == null) {
            pedido.setItens(new ArrayList<>());
        }
        pedido.getItens().add(itemPedido);

        // Persistir o novo ItemPedido
        itemPedidoRepository.persist(itemPedido);

        // Calcular o valor total do pedido
        double valorTotal = pedido.getItens().stream()
                .mapToDouble(item -> item.getJoia().getPreco() * item.getQuantidade())
                .sum();

        // Verificar se já existe um pagamento associado ao pedido
        Pagamento pagamento = pagamentoRepository.findByPedidoId(pedido.getId());
        if (pagamento == null) {
            // Criar e persistir um novo Pagamento se não existir
            pagamento = new Pagamento();
            pagamento.setPedido(pedido);
            pagamento.setValorTotal(valorTotal);
            pagamento.setMetodo(null);
            pagamento.setStatus(StatusPagamento.PENDENTE);
            pagamento.setDataPagamento(LocalDate.now());

            pagamentoRepository.persist(pagamento);
        } else {
            // Atualizar o valor total do pagamento existente
            pagamento.setValorTotal(valorTotal);
            pagamentoRepository.persist(pagamento);
        }

        return toResponseDTO(itemPedido);
    }

    @Override
    @Transactional
    public ItemPedidoResponseDTO update(ItemPedidoDTO dto, Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id);
        if (itemPedido == null) {
            throw new IllegalArgumentException("ItemPedido não encontrado");
        }

        itemPedido.setQuantidade(dto.quantidade());
        itemPedido.setTipoPedido(dto.tipoPedido());

        Joia produto = joiaRepository.findById(dto.idPedido());
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        itemPedido.setJoia(produto);

        itemPedidoRepository.persist(itemPedido);
        return toResponseDTO(itemPedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id);
        if (itemPedido == null) {
            throw new IllegalArgumentException("ItemPedido não encontrado");
        }
        itemPedidoRepository.delete(itemPedido);
    }

    @Override
    public ItemPedidoResponseDTO findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id);
        if (itemPedido == null) {
            throw new IllegalArgumentException("ItemPedido não encontrado");
        }
        return toResponseDTO(itemPedido);
    }

//    @Override
//    public List<ItemPedidoResponseDTO> findByNome(String nome) {
//        // Aqui, você precisará ajustar a lógica de acordo com o seu modelo
//        // Supondo que o nome está relacionado ao produto
//        List<ItemPedido> itens = itemPedidoRepository.find("produto.nome", nome).list();
//        return itens.stream().map(this::toResponseDTO).collect(Collectors.toList());
//    }

    @Override
    public List<ItemPedidoResponseDTO> findByAll() {
        return itemPedidoRepository.listAll().stream()
                .map(e -> ItemPedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public ItemPedido fromDTO(ItemPedidoDTO dto, Pedido pedido) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(dto.quantidade());
        itemPedido.setTipoPedido(dto.tipoPedido());
        itemPedido.setPedido(pedido); // Associa o pedido ao item do pedido
        return itemPedido;
    }


    private ItemPedidoResponseDTO toResponseDTO(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO(
                itemPedido.getQuantidade(),
                itemPedido.getJoia().getId()// Supondo que Produto tem um campo nome
        );
    }
}
