package org.acme.dto.Anel;

import org.acme.model.Anel;

public record AnelResponseDTO(

    Double tamanho,
    String imgAnel

) {

public static AnelResponseDTO valueOf(Anel anel){

    return new AnelResponseDTO(
        anel.getTamanho(),
        anel.getImgAnel());
}
}