package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record PedraPreciosaDTO(

        @NotBlank(message = "Informe qual tipo de pedra")
        Integer idPedra,
        @NotBlank(message = "Informe o peso da pedra")
        String peso,
        @NotBlank(message = "Informe a quantidade de pedras")
        Integer quantidade,
        Integer idCor) {
}