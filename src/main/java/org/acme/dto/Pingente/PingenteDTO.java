package org.acme.dto.Pingente;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PingenteDTO(

        @NotBlank(message = "Nome não pode ser nulo!")
        String nome,
        @NotBlank(message = "Pedra precisa ser preenchida!")
        List<Long> idPedrasPreciosas,

        @NotBlank(message = "Material não pode ser nulo!")
        Integer idMaterial,

        @NotBlank(message = "Cor não pode ser nula!")
        Integer idCor
) {
}
