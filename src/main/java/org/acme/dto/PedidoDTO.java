package org.acme.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record PedidoDTO(
        @NotNull(message = "A pessoa associada ao pedido não pode ser nula") PessoaDTO pessoa,
        List<ItemPedidoDTO> itens
) {}