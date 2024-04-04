package org.acme.dto.Cidade;

import org.acme.dto.Estado.EstadoResponseDTO;
import org.acme.model.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado
) { 
    public static CidadeResponseDTO valueOf(Cidade cidade){

        return new CidadeResponseDTO(
            cidade.getId(),
            cidade.getNome(),
            EstadoResponseDTO.valueOf(cidade.getEstado()));
    }
   
}