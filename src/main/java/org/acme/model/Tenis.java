package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
public class Tenis extends DefaultEntity {

    @NotBlank(message = "Insira o nome do produto")
    private String nome;

    @NotBlank(message = "Insira o preco")
    private Double preco;

    @NotBlank(message = "Insira o preço de compra")
    private Double precoCompra;

    private String descricao;

    private String nomeImagem;

    @NotBlank(message = "Insira a quantidade de estoque")
    private int estoque;

    // private imgProduto

}
