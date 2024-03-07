package org.acme.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class CarrinhoDeCompras {
    
    private List<ItemCarrinho> itens;
}
