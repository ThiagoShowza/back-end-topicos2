package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ItemCarrinho {

    @NotBlank(message = "Informe a quantidade de itens")
    
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_ tenis")
    private Tenis tenis;
}