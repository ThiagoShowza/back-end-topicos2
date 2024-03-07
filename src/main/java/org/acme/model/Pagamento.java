package org.acme.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    @NotNull(message = "O método de pagamento não pode ser nulo")
    private MetodoDePagamento metodo;

    @NotNull(message = "O status do pagamento não pode ser nulo")
    private StatusPagamento status;

    @NotNull(message = "A data de pagamento não pode ser nula")
    private LocalDate dataPagamento;

    @ManyToOne
    private CarrinhoDeCompras carrinho;

}
