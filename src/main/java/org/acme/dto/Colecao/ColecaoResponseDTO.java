package org.acme.dto.Colecao;

import org.acme.dto.Pessoa.PessoaResponseDTO;
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
