package org.acme.dto.Pagamento;

import java.time.LocalDate;

import org.acme.dto.Pedido.PedidoResponseDTO;
import org.acme.model.MetodoDePagamento;
import org.acme.model.Pagamento;
import org.acme.model.Pedido;
import org.acme.model.StatusPagamento;
import org.acme.service.Pedido.PedidoService;

public record PagamentoResponseDTO(
        Double valorTotal,
        MetodoDePagamento metodo,
        StatusPagamento status,
        LocalDate dataPagamento,
        PedidoResponseDTO pedidoResponseDTO) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento, Pedido pedido) {
        return new PagamentoResponseDTO(
                pagamento.getValorTotal(),
                pagamento.getMetodo(),
                pagamento.getStatus(),
                pagamento.getDataPagamento(),
                PedidoResponseDTO.valueOf(pedido));
    }

}