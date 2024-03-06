package org.acme.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Cidade extends DefaultEntity{

    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;
    private Estado estado;
    
}
