package org.acme.dto;

import java.time.LocalDate;
import java.util.List;

import org.acme.model.Pessoa;

public record PessoaResponseDTO(
        String nome,
        String cpf,
        String telefone,
        LocalDate dataNascimento,
        List<EnderecoResponseDTO> listaEndereco,
        String nomeImagem

) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getTelefone(),
                pessoa.getDataNascimento(),
                pessoa.getListaEndereco().stream().
                map(t -> EnderecoResponseDTO.valueOf(t)).toList(),
                pessoa.getNomeImagem());

    }

}