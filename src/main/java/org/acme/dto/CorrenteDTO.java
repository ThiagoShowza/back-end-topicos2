package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CorrenteDTO(

    @NotBlank(message = "Informe o comprimento da corrente")
    Double comprimento,
    @NotBlank(message = "Informe o tipo de Fecho")
    Integer idFecho,
    @NotBlank(message = "Informe o tipo de Elo")
    Integer idElo,
    @NotBlank(message = "Informe os dados da Joia")
    JoiaResponseDTO joia,
    String imgProduto,
    PingenteResponseDTO pingente


) {
}