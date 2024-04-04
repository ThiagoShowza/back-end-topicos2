package org.acme.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joia extends DefaultEntity {

    @NotBlank(message = "Informe o nome do produto")
    private String nome;

    @NotBlank(message = "Informe o Material")
    private Material material;

    private String descricao;

    @OneToMany(mappedBy = "joia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedraPreciosa> listaPedras;

    @NotBlank(message = "Informe o preco")
    private Double preco;

    @NotBlank(message = "Informe a quantidade de estoque")
    private Integer estoque;

    @NotBlank(message = "Informe a cor")
    private Cor cor;

    @NotBlank(message = "Informe o peso")
    private Double peso;
}
