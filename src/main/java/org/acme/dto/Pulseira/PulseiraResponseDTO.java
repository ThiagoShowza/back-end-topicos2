package org.acme.dto.Pulseira;

import org.acme.dto.Pingente.PingenteResponseDTO;
import org.acme.model.Pulseira;
import org.acme.model.TipoElo;
import org.acme.model.TipoFecho;

public record PulseiraResponseDTO(

        Long id,
        Double comprimento,
        String nomeImagem,
        TipoFecho tipoFecho,
        TipoElo tipoElo,
        PingenteResponseDTO pingente

) {

    public static PulseiraResponseDTO valueOf(Pulseira pulseira) {

        return new PulseiraResponseDTO(
                pulseira.getId(),
                pulseira.getComprimento(),
                pulseira.getNomeImagem(),
                pulseira.getTipoFecho(),
                pulseira.getTipoElo(),
                PingenteResponseDTO.valueOf(pulseira.getPingente()));
    }

}
