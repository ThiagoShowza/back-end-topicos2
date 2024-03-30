package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record EstadoDTO(
        @NotBlank(message = "O nome do estado não pode ser nulo") String nome,
        @NotBlank(message = "Insira a sigla do Estado") 
        String sigla) {
}