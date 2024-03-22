package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record PingenteDTO(
        @NotBlank(message = "Pedra precisa ser preenchida!")
        Long idPedraPreciosa,

        @NotBlank(message = "Material não pode ser nulo!")
        Long idMaterial,

        @NotBlank(message = "Cor não pode ser nula!")
        Long idCor
) {
}
