package org.acme.dto.Pingente;

import org.acme.dto.PedraPreciosa.PedraPreciosaResponseDTO;
import org.acme.model.*;

import java.util.List;

public record PingenteResponseDTO(
        Long id,
        List<PedraPreciosaResponseDTO> pedrasPreciosa,

        Material material,

        Cor cor
) {
    public static PingenteResponseDTO valueOf(Pingente pingente) {

        return new PingenteResponseDTO(
                pingente.getId(),
                pingente.getPedraPreciosa()
                        .stream()
                        .map(p -> PedraPreciosaResponseDTO.valueOf(p)).toList(),
                pingente.getMaterial(),
                pingente.getCor());
    }
}
