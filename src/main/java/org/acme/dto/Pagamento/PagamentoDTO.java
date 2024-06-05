package org.acme.dto.Pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.model.MetodoDePagamento;

import java.time.LocalDate;

public record PagamentoDTO(
        @NotNull(message = "O método de pagamento não pode ser nula")
        MetodoDePagamento metodo,
        Long idPedido
) {}