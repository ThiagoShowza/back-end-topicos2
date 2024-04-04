package org.acme.dto.Anel;

import jakarta.validation.constraints.NotBlank;

public record AnelDTO(

        @NotBlank(message = "Informe o tamanho do anel")
        Double tamanho,
        String imgAnel

) {
}