package org.acme.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
public class Pagamento {


    @Positive(message = "O valor total deve ser maior que zero")
    private Double valorTotal;

    @NotBlank(message = "O método de pagamento não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_metodo_pagamento")
    private MetodoDePagamento metodo;

    @NotBlank(message = "O status do pagamento não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_metodo_pagamento")
    private StatusPagamento status;

    @NotBlank(message = "A data de pagamento não pode ser nula")
    private LocalDate dataPagamento;

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    private CarrinhoDeCompras carrinho;

}
