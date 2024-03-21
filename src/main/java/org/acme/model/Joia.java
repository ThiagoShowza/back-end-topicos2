package org.acme.model;

import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Joia extends DefaultEntity {

    @NotBlank(message = "Informe o nome do produto")
    private String nome;

    @NotBlank(message = "Informe o Material")
    private Material material;

    private String descricao;

    @OneToMany(mappedBy = "Joia")
    @JoinTable(name = "joia_Pedra", joinColumns = @JoinColumn(name = "id_joia"), inverseJoinColumns = @JoinColumn(name = "id_pedra"))
    private List<PedraPreciosa> listaPedras;

    @NotBlank(message = "Informe o preco")
    private Double preco;

    @NotBlank(message = "Informe a quantidade de estoque")
    private Integer estoque;

    private Cor cor;

    private Double peso;
}
