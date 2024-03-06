package org.acme.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class CarrinhoDeCompras {
    
    private List<ItemCarrinho> itens;
}
