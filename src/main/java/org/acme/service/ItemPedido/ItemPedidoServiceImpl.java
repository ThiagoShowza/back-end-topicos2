package org.acme.service.ItemPedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.ItemPedido.ItemPedidoDTO;
import org.acme.dto.ItemPedidoResponseDTO;
import org.acme.dto.Joia.JoiaResponseDTO;
import org.acme.model.ItemPedido;
import org.acme.model.Joia;
import org.acme.model.Pedido;
import jakarta.inject.Inject;
import org.acme.model.Pessoa;
import org.acme.repository.ItemPedidoRepository;
import org.acme.repository.JoiaRepository;
import org.acme.repository.PedidoRepository;
import org.acme.repository.PessoaRepository;

import java.util.List;


@ApplicationScoped
public class ItemPedidoServiceImpl implements ItemPedidoService{

    @Inject
    ItemPedidoRepository itemPedidoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    JoiaRepository joiaRepository;

    @Inject
    PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public ItemPedidoResponseDTO insert(ItemPedidoDTO dto) {
        // Primeiro, tentamos encontrar um Pedido existente para o cliente
        Pedido pedido = pedidoRepository.findByPessoaId(1L);

        // Se não houver um Pedido existente, criamos um novo
        if (pedido == null) {
            pedido = new Pedido();
            Pessoa cliente = pessoaRepository.findById(1L);
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não encontrado");
            }
            pedido.setPessoa(cliente);
            // Persistir o novo Pedido
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

        // Persistir o novo ItemPedido
        itemPedidoRepository.persist(itemPedido);

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
