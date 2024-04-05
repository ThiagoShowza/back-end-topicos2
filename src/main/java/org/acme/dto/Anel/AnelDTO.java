package org.acme.dto.Anel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.dto.Joia.JoiaDTO;

public record AnelDTO(

        JoiaDTO joiaDTO,

        @NotBlank(message = "Insira o tamanho do anel")
        Double tamanho,
        String imgAnel
) {
}