package org.acme.dto.ItemPedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.acme.model.TipoPedido;

public record ItemPedidoDTO(

    @NotBlank(message = "Informe a quantidade de itens")
    @Positive(message = "A quantidade não pode ser 0 ou negativo")
    Integer quantidade,
    Long idPedido,

    TipoPedido tipoPedido

) {
}
