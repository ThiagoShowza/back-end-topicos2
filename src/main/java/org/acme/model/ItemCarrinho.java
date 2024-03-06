package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ItemCarrinho {

    @NotBlank(message = "Informe uma quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_ produto")
    private Produto produto;
}