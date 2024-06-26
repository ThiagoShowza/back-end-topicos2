package org.acme.dto.Pessoa;

import java.time.LocalDate;
import java.util.List;

import org.acme.dto.Endereco.EnderecoResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Pessoa;

public record PessoaResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone,
        LocalDate dataNascimento,
        List<EnderecoResponseDTO> listaEndereco,
        String nomeImagem

) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getTelefone(),
                pessoa.getDataNascimento(),
                pessoa.getListaEndereco().stream().
                map(t -> EnderecoResponseDTO.valueOf(t)).toList(),
                pessoa.getNomeImagem());

    }

}