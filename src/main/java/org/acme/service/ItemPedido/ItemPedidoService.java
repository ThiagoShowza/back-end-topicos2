package org.acme.service.ItemPedido;

import jakarta.validation.Valid;
import org.acme.dto.ItemPedido.ItemPedidoDTO;
import org.acme.dto.ItemPedido.ItemPedidoResponseDTO;
import org.acme.dto.Joia.JoiaDTO;
import org.acme.dto.Joia.JoiaResponseDTO;
import org.acme.model.ItemPedido;
import org.acme.model.Pedido;

import java.util.List;

public interface ItemPedidoService {
    public ItemPedidoResponseDTO insert(@Valid ItemPedidoDTO dto);

    public ItemPedidoResponseDTO update(ItemPedidoDTO dto, Long id);

    public void delete(Long id);

    public ItemPedidoResponseDTO findById(Long id);

//    public List<ItemPedidoResponseDTO> findByNome(String nome);

    ItemPedido fromDTO(ItemPedidoDTO dto, Pedido pedido); // Adiciona este método na interface

    public List<ItemPedidoResponseDTO> findByAll();
}
