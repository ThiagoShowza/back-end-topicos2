package org.acme.dto.Corrente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.dto.Joia.JoiaDTO;

public record CorrenteDTO(

        JoiaDTO joiaDTO,

        @NotBlank(message = "Insira o nome do produto")
        Double comprimento,
        String nomeImagem,
        @NotNull(message = "Insira a quantidade de estoque")
        Integer idFecho,
        Integer idElo,
        Long idPingente
) {}