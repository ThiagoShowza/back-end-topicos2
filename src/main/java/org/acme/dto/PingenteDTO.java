package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PingenteDTO(
        @NotBlank(message = "Pedra precisa ser preenchida!")
        List<Long> idPedrasPreciosas,

        @NotBlank(message = "Material não pode ser nulo!")
        Integer idMaterial,

        @NotBlank(message = "Cor não pode ser nula!")
        Integer idCor
) {
}
