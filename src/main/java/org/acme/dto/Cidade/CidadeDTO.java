package org.acme.dto.Cidade;

import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(

        @NotBlank(message = "O nome não pode ser nulo") String nome,
        Long idEstado) {

}
