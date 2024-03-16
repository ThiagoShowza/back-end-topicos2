package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TenisDTO(
        @NotBlank(message = "Insira o nome do produto") String nome,
        @NotNull(message = "Insira o preco") Double preco,
        String descricao,
        @NotNull(message = "Insira a quantidade de estoque") Integer estoque,
        String imgProduto,
        Integer idTamanho,
        Integer idCor
        ) {

}
