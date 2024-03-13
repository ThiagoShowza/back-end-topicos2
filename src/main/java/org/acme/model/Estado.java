package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Estado {

    @Column(length = 60, nullable = false)
    @NotBlank(message = "O nome do estado não pode ser nulo")
    private String nome;

    @Column(length =2, nullable = false)
    @NotBlank(message = "Insira a sigla do Estado")
    private String sigla;
}
