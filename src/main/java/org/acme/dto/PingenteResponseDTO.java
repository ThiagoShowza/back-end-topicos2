package org.acme.dto;

import org.acme.model.*;

import java.util.List;

public record PingenteResponseDTO(
        Long id,
        List<PedraPreciosaDTO> pedrasPreciosa,

        Material material,

        Cor cor
) {
    public static PingenteResponseDTO valueOf(Pingente pingente) {

        return new PingenteResponseDTO(
                pingente.getId(),
                pingente.getListaPedras()
                        .stream()
                        .map(p -> PedraPreciosaResponseDTO.valueOf(p)).toList(),
                pingente.getMaterial(),
                pingente.getCor());
    }
}
