package org.acme.dto.Estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstadoDTO(
        @NotBlank(message = "O nome do estado não pode ser nulo")
        String nome,
        @NotNull(message = "O campo sigla não pode ser nulo.")
        @Size(min = 2, max = 2, message = "A sigla deve ter 2 digitos")
        String sigla) {
}