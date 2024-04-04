//package org.acme.dto;
//
//import java.time.LocalDate;
//
//import org.acme.model.MetodoDePagamento;
//import org.acme.model.Pagamento;
//import org.acme.model.StatusPagamento;
//
//public record PagamentoResponseDTO(
//        Double valorTotal,
//        MetodoDePagamento metodo,
//        StatusPagamento status,
//        LocalDate dataPagamento,
//        Long idPedido) {
//    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
//        return new PagamentoResponseDTO(
//                pagamento.getValorTotal(),
//                pagamento.getMetodo(),
//                pagamento.getStatus(),
//                pagamento.getDataPagamento(),
//                pagamento.getPedido().getId());
//
//    }
//
//}