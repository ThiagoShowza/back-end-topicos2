package org.acme.dto;

import org.acme.model.Pulseira;
import org.acme.model.TipoElo;
import org.acme.model.TipoFecho;

public record PulseiraResponseDTO(

        Long id,
        Double comprimento,
        String imgPulseira,
        TipoFecho tipoFecho,
        TipoElo tipoElo,
        JoiaResponseDTO joia,
        PingenteResponseDTO pingente

) {

    public static PulseiraResponseDTO valueOf(Pulseira pulseira) {

        return new PulseiraResponseDTO(
                pulseira.getId(),
                pulseira.getComprimento(),
                pulseira.getImgPulseira(),
                pulseira.getTipoFecho(),
                pulseira.getTipoElo(),
                JoiaResponseDTO.valueOf(pulseira.getJoia()),
                PingenteResponseDTO.valueOf(pulseira.getPingente()));
    }

}
