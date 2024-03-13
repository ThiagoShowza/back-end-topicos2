package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ItemPedido {

    @NotBlank(message = "Informe a quantidade de itens")
    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_ tenis")
    private Tenis tenis;
}