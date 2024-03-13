package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(

        @NotBlank(message = "O nome não pode ser nulo") String nome,
        EstadoDTO estado) {

}
