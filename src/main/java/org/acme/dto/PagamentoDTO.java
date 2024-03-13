package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PagamentoDTO(
        @NotNull(message = "O valor total deve ser maior que zero") Double valorTotal,
        @NotBlank(message = "O método de pagamento não pode ser nulo") Integer idMetodo,
        @NotBlank(message = "O status do pagamento não pode ser nulo") Integer idStatus,
        @NotNull(message = "A data de pagamento não pode ser nula") LocalDate dataPagamento,
        Long idPedido
) {}