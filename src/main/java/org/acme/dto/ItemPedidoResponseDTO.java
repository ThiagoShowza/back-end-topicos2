package org.acme.dto;

import java.util.List;
import org.acme.model.ItemPedido;

public record ItemPedidoResponseDTO(
        Integer quantidade,
        Long idTenis) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido item){
            return new ItemPedidoResponseDTO(
                item.getQuantidade(),
                item.getTenis().getId());
        }

    public static List<ItemPedidoResponseDTO> valueOf(List<ItemPedido> item){
        return item.stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList();
    }
}
