package org.acme.dto;

import org.acme.model.Cor;
import org.acme.model.Tamanho;
import org.acme.model.Tenis;

public record TenisResponseDTO(

        String nome,
        Double preco,
        String descricao,
        Integer estoque,
        String imgProduto,
        Tamanho tamanho,
        Cor cor

) {
    public static TenisResponseDTO valueOf(Tenis tenis) {
        return new TenisResponseDTO(
                tenis.getNome(),
                tenis.getPreco(),
                tenis.getDescricao(),
                tenis.getEstoque(),
                tenis.getImgProduto(),
                tenis.getTamanho(),
                tenis.getCor());

    }
}