package org.acme.dto;

import org.acme.model.Cidade;

import jakarta.validation.constraints.Positive;

public record CidadeResponseDTO(
        @Positive(message = "Id invalido") Long id,
        String nome,
        EstadoResponseDTO estado) {
    public static CidadeResponseDTO valueOf(Cidade cidade) {

        return new CidadeResponseDTO(
                cidade.getId(),
                cidade.getNome(),
                EstadoResponseDTO.valueOf(cidade.getEstado()));
    }

}