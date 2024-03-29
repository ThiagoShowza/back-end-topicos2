package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record AnelDTO(

        @NotBlank(message = "Informe o tamanho do anel")
        Double tamanho,
        String imgAnel,
        @NotBlank(message = "Informe os dados da Joia")
        JoiaResponseDTO joia

) {
}