package org.acme.dto;

import java.time.LocalDate;

import org.acme.model.Perfil;
import org.acme.model.Pessoa;

public record PessoaResponseDTO(
        String nome,
        String senha,
        String cpf,
        String telefone,
        String email,
        LocalDate dataNascimento,
        EnderecoResponseDTO endereco,
        Perfil perfil,
        String nomeImagem

) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa){
        return new PessoaResponseDTO(
            pessoa.getNome(),
            pessoa.getSenha(), 
            pessoa.getCpf(), 
            pessoa.getTelefone(), 
            pessoa.getEmail(), 
            pessoa.getDataNascimento(), 
            EnderecoResponseDTO.valueOf(pessoa.getEndereco()), 
            pessoa.getPerfil(), 
            pessoa.getNomeImagem());

    }

}