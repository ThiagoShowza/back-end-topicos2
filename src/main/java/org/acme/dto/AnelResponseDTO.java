package org.acme.dto;

import org.acme.model.Anel;

public record AnelResponseDTO(

    Double tamanho,
    String imgAnel,
    JoiaResponseDTO joia
) {

public static AnelResponseDTO valueOf(Anel anel){

    return new AnelResponseDTO(
        anel.getTamanho(),
        anel.getImgAnel(),
        JoiaResponseDTO.valueOf(anel.getJoia()));
}
}