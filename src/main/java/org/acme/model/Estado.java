package org.acme.model;

import jakarta.validation.constraints.NotBlank;

public class Estado {
    
    @NotBlank(message = "O nome do estado não pode ser nulo")
    private String nome;
}
