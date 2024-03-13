package org.acme.dto;

import java.util.List;

import org.acme.model.Pedido;
import org.acme.model.Pessoa;

public record PedidoResponseDTO(
        Pessoa pessoa,
        List<ItemPedidoDTO> itens) {

    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getPessoa(),
            ItemPedidoResponseDTO.valueOf(pedido.getItens()));
        
    }
}