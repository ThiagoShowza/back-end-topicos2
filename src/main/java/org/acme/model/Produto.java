package org.acme.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
public class Produto extends DefaultEntity {

    private String nome;

    private Double preco;

    private String descricao;

    private int estoque;

    // private imgProduto

}
