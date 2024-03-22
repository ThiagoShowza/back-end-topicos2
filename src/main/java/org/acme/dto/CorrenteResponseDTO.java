package org.acme.dto;

import org.acme.model.Corrente;
import org.acme.model.TipoElo;
import org.acme.model.TipoFecho;

public record CorrenteResponseDTO(

        Double comprimento,
        TipoFecho tipoFecho,
        TipoElo tipoElo,
        JoiaResponseDTO joia,
        String imgProduto,
        PingenteResponseDTO pingente) {

    public static CorrenteResponseDTO valueOf(Corrente corrente){
        return new CorrenteResponseDTO(
            corrente.getComprimento(),
            corrente.getTipofecho(),
            corrente.getTipoElo(),
            JoiaResponseDTO.valueOf(corrente.getJoia()),
            corrente.getImgCorrente(),
            PingenteResponseDTO.valueOf(corrente.getPingente()));
    }
    

}