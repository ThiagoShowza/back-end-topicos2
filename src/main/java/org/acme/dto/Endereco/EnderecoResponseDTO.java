package org.acme.dto.Endereco;

import org.acme.dto.Cidade.CidadeResponseDTO;
import org.acme.model.Endereco;

public record EnderecoResponseDTO(

        CidadeResponseDTO cidade,
        String cep,
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