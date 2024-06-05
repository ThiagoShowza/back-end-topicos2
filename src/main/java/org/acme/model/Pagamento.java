package org.acme.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pagamento extends DefaultEntity {

    @Positive(message = "O valor total deve ser maior que zero")
    @NotNull(message = "O valor total não pode ser nulo")
    private Double valorTotal;

    private MetodoDePagamento metodo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status do pagamento não pode ser nulo")
    private StatusPagamento status;

    @NotNull(message = "A data de pagamento não pode ser nula")
    private LocalDate dataPagamento;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
