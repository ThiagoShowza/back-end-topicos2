//package org.acme.dto;
//
//import java.util.List;
//
//import org.acme.model.Pedido;
//
//public record PedidoResponseDTO(
//        PessoaResponseDTO pessoa,
//        List<ItemPedidoResponseDTO> itens) {
//
//    public static PedidoResponseDTO valueOf(Pedido pedido){
//        return new PedidoResponseDTO(
//            PessoaResponseDTO.valueOf(pedido.getPessoa()),
//            ItemPedidoResponseDTO.valueOf(pedido.getItens()));
//
//    }
//}