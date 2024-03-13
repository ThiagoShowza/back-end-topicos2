package org.acme.dto;

import org.acme.model.Tenis;

public record TenisResponseDTO(

        String nome,
        Double preco,
        String descricao,
        String imgProduto,
        Integer estoque

) {
    public static TenisResponseDTO valueOf(Tenis tenis) {
        return new TenisResponseDTO(
                tenis.getNome(),
                tenis.getPreco(),
                tenis.getDescricao(),
                tenis.getImgProduto(),
                tenis.getEstoque());

    }
}