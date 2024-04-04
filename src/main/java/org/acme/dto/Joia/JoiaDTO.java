package org.acme.dto.Joia;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record JoiaDTO(
    @NotBlank(message = "Informe o nome do produto")
    String nome,
    @NotBlank(message = "Informe o Material")
    Integer idMaterial,
    String descricao,
    List<Long> listaIdsPedras,
    @NotBlank(message = "Informe o preco")
    Double preco,
    @NotBlank(message = "Informe a quantidade de estoque")
    Integer estoque,
    Integer idCor,
    Double peso



) {

}