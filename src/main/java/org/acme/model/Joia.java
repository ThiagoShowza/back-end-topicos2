package org.acme.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Joia extends DefaultEntity {

    @NotBlank(message = "Insira o nome do produto")
    private String nome;

    @NotBlank(message = "Informe o Material")
    private Material material;

    @OneToMany(mappedBy = "Joia")
    @JoinTable(name = "joia_Pedra", joinColumns = @JoinColumn (name = "id_joia"), inverseJoinColumns = @JoinColumn(name = "id_pedra"))
    private List<PedraPreciosa> listaPedras;

    @NotBlank(message = "Insira o preco")
    private Double preco;

    @NotBlank(message = "Insira a quantidade de estoque")
    private int estoque;

    private String imgProduto;

    private Cor cor;
}
