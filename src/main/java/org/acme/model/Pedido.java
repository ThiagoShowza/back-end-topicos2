package org.acme.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Pedido extends DefaultEntity{
    
    @NotNull(message = "A pessoa associada ao pedido não pode ser nula")
    private Pessoa pessoa;

    private List<ItemPedido> itens;
}
