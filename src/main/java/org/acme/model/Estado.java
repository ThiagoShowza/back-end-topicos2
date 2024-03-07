package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Estado {

    @NotBlank(message = "O nome do estado não pode ser nulo")
    private String nome;

    @NotBlank(message = "Insira a sigla do Estado")
    private String sigla;
}
