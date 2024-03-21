package org.acme.dto;

import org.acme.model.TipoElo;
import org.acme.model.TipoFecho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PulseiraDTO(
        @NotBlank(message = "Insira o nome do produto") 
        Double comprimento,
        String imgPulseira,
        @NotNull(message = "Insira a quantidade de estoque")
        TipoFecho tipoFecho,
        TipoElo tipoElo,
        JoiaResponseDTO joia,
        PingenteResponseDTO pingente
        ) {
                

}