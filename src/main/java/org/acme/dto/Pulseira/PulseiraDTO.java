package org.acme.dto.Pulseira;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.dto.Joia.JoiaDTO;

public record PulseiraDTO(

        JoiaDTO joiaDTO,

        @NotBlank(message = "Insira o nome do produto")
        Double comprimento,
        String nomeImagem,
        @NotNull(message = "Insira a quantidade de estoque")
        Integer idFecho,
        Integer idElo,
        Long idPingente
        ) {

}