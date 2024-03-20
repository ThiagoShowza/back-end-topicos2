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
public class ItemPedido extends DefaultEntity {

    @NotBlank(message = "Informe a quantidade de itens")
    @Positive(message = "A quantidade inválida")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_joia")
    private Joia joia;
}