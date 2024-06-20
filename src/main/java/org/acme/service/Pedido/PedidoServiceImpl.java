package org.acme.service.Pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.dto.Pedido.PedidoDTO;
import org.acme.dto.Pedido.PedidoResponseDTO;
import org.acme.model.ItemPedido;
import org.acme.model.Pedido;
import org.acme.model.Pessoa;
import jakarta.inject.Inject;
import org.acme.repository.PedidoRepository;
import org.acme.repository.PessoaRepository;
import org.acme.service.Auth.AuthService;
import org.acme.service.ItemPedido.ItemPedidoService;

import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class PedidoServiceImpl implements PedidoService{

    @Inject
    AuthService authService;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    ItemPedidoService itemPedidoService;

    @Override
    public List<PedidoResponseDTO> findPedidosUsuarioLogado(String email) {
        // 1. Obter o usuário pelo email
        LoginResponseDTO usuarioDTO = authService.findByEmail(email);
        if (usuarioDTO == null) {
            throw new EntityNotFoundException("Usuário não encontrado com o email: " + email);
        }

        // 2. Obter os pedidos associados ao usuário
        Long usuarioPessoaId = usuarioDTO.pessoa().id(); // Supondo que o usuário tenha um ID único
        List<Pedido> pedidos = pedidoRepository.findByPessoaId(usuarioPessoaId);

        // 3. Mapear os pedidos para DTOs de resposta
        return pedidos.stream()
                .map(PedidoResponseDTO::valueOf) // Supondo que há um método estático valueOf em PedidoResponseDTO para conversão
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {
        Pedido pedido = new Pedido();

        Pessoa pessoa = pessoaRepository.findById(dto.idPessoa());
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }
        pedido.setPessoa(pessoa);
        List<ItemPedido> itens = dto.itens().stream()
                .map(itemDTO -> itemPedidoService.fromDTO(itemDTO, pedido)) // Uso do método fromDTO
                .collect(Collectors.toList());
        pedido.setItens(itens);


        pedidoRepository.persist(pedido);
        return  PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        Pessoa pessoa = pessoaRepository.findById(dto.idPessoa());
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }
        pedido.setPessoa(pessoa);
        List<ItemPedido> itens = dto.itens().stream()
                .map(itemDTO -> itemPedidoService.fromDTO(itemDTO, pedido)) // Uso do método fromDTO
                .collect(Collectors.toList());
        pedido.setItens(itens);

        pedidoRepository.persist(pedido);
        return  PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        pedidoRepository.delete(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

//    private PedidoResponseDTO toResponseDTO(Pedido pedido) {
//        // Converter a Pessoa para PessoaResponseDTO
//        PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO(pedido.getPessoa().getId(), pedido.getPessoa().getNome());
//
//        // Converter os itens do pedido para ItemPedidoResponseDTO
//        List<ItemPedidoResponseDTO> itensResponseDTO = pedido.getItens().stream()
//                .map(itemPedidoService::toResponseDTO) // Supondo que haja um método toResponseDTO em ItemPedidoService
//                .collect(Collectors.toList());
//
//        // Criar e retornar o PedidoResponseDTO com os objetos convertidos
//        return new PedidoResponseDTO(
//                pedido.getId(),
//                pessoaResponseDTO,
//                itensResponseDTO
//        );
//    }

}
