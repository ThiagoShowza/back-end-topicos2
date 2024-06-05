package org.acme.dto.Anel;

import org.acme.model.Anel;

public record AnelResponseDTO(

        Long id,
    Double tamanho,
    String imgAnel

) {

public static AnelResponseDTO valueOf(Anel anel){

    return new AnelResponseDTO(
            anel.getId(),
        anel.getTamanho(),
        anel.getImgAnel());
}
}