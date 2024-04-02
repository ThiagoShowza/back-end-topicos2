package org.acme.dto;

import org.acme.model.Estado;

import jakarta.validation.constraints.Positive;

public record EstadoResponseDTO(
        @Positive(message = "Id invalido") Long id,
        String nome,
        String sigla

) {
    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
                estado.getId(),
                estado.getNome(),
                estado.getSigla());
    }

}
