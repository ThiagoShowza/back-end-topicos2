package org.acme.dto.Pedido;

import java.util.List;

import org.acme.dto.ItemPedidoResponseDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.model.Pedido;

public record PedidoResponseDTO(
        Long id,
        PessoaResponseDTO pessoa,
        List<ItemPedidoResponseDTO> itens) {

    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
            PessoaResponseDTO.valueOf(pedido.getPessoa()),
            ItemPedidoResponseDTO.valueOf(pedido.getItens()));

    }
}