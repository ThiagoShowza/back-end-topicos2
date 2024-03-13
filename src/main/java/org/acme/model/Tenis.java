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

    private String descricao;

    private String imgProduto;

    @NotBlank(message = "Insira a quantidade de estoque")
    private int estoque;

}
