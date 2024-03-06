package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cidade extends DefaultEntity {

    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

}
