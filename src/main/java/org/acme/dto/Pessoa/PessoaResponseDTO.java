package org.acme.dto.Pessoa;

import java.time.LocalDate;
import java.util.List;

import org.acme.dto.Endereco.EnderecoResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Pessoa;

public record PessoaResponseDTO(
        String nome,
        String senha,
        String cpf,
        String telefone,
        String email,
        LocalDate dataNascimento,
        List<EnderecoResponseDTO> listaEndereco,
        Perfil perfil,
        String nomeImagem

) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
                pessoa.getNome(),
                pessoa.getSenha(),
                pessoa.getCpf(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getDataNascimento(),
                pessoa.getListaEndereco().stream().
                map(t -> EnderecoResponseDTO.valueOf(t)).toList(),
                pessoa.getPerfil(),
                pessoa.getNomeImagem());

    }

}