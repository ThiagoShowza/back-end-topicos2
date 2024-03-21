package org.acme.dto;

import org.acme.model.PedraPreciosa;

import jakarta.validation.constraints.NotBlank;

public record PedraPreciosaDTO(

        @NotBlank(message = "Informe qual tipo de pedra")
        Integer idPedra,
        @NotBlank(message = "Informe o peso da pedra")
        String peso,
        @NotBlank(message = "Informe a quantidade de pedras")
        Integer quantidade,
        Integer idCor) {

            public static PedraPreciosaDTO valueOf(PedraPreciosa pedraPreciosa){
                return new PedraPreciosaDTO(
                    pedraPreciosa.getPedra().getId(), 
                    pedraPreciosa.getPeso(), 
                    pedraPreciosa.getQuantidade(), 
                    pedraPreciosa.getCor().getId());
            }

}