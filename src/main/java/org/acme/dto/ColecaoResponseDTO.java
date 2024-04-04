package org.acme.dto;

import org.acme.model.Cidade;
import org.acme.model.Colecao;

public record ColecaoResponseDTO(
        Long id,
        String nome,
        String descricao,

        PessoaResponseDTO pessoaResponseDTO
) {
    public static ColecaoResponseDTO valueOf(Colecao colecao){

        return new ColecaoResponseDTO(
                colecao.getId(),
                colecao.getNome(),
                colecao.getDescricao(),
                PessoaResponseDTO.valueOf(colecao.getPessoa()));
    }
}
