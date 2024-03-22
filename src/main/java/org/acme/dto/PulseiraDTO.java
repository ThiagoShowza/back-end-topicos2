package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PulseiraDTO(
        @NotBlank(message = "Insira o nome do produto") 
        Double comprimento,
        String imgPulseira,
        @NotNull(message = "Insira a quantidade de estoque")
        Integer idFecho,
        Integer idElo,
        JoiaResponseDTO joia,
        PingenteResponseDTO pingente
        ) {
                

}