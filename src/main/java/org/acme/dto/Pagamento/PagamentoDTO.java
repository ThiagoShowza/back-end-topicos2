package org.acme.dto.Pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PagamentoDTO(
        @NotNull(message = "O valor total deve ser maior que zero") Double valorTotal,
        @NotBlank(message = "O método de pagamento não pode ser nulo") Long idMetodo,
        @NotBlank(message = "O status do pagamento não pode ser nulo") Long idStatus,
        @NotNull(message = "A data de pagamento não pode ser nula") LocalDate dataPagamento,
        Long idPedido
) {}