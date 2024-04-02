package org.acme.dto;

import org.acme.model.Endereco;

public record EnderecoResponseDTO(

        CidadeResponseDTO cidade,
        Integer cep,
        Integer numero,
        String bairro,
        String logradouro,
        String complemento) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {

        return new EnderecoResponseDTO(
                CidadeResponseDTO.valueOf(endereco.getCidade()),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getLogradouro(),
                endereco.getComplemento());

    }
}