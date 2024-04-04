package org.acme.dto.ItemPedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ItemPedidoDTO(

    @NotBlank(message = "Informe a quantidade de itens")
    @Positive(message = "O CEP não pode ser 0 ou negativo")
    Integer quantidade,
    Long idJoia

) {
}
