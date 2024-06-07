package org.acme.dto.Corrente;

import org.acme.dto.Pingente.PingenteResponseDTO;
import org.acme.model.Corrente;
import org.acme.model.TipoElo;
import org.acme.model.TipoFecho;

public record CorrenteResponseDTO(

        Long id,
        Double comprimento,
        TipoFecho tipoFecho,
        TipoElo tipoElo,
        String nomeImagem,
        PingenteResponseDTO pingente) {

    public static CorrenteResponseDTO valueOf(Corrente corrente){
        return new CorrenteResponseDTO(
                corrente.getId(),
            corrente.getComprimento(),
            corrente.getTipofecho(),
            corrente.getTipoElo(),
            corrente.getNomeImagem(),
            PingenteResponseDTO.valueOf(corrente.getPingente()));
    }


}