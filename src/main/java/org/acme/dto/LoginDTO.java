package org.acme.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
    @NotEmpty(message = "O campo não pode ser nulo")
    String email,

    @NotEmpty(message = "O campo senha não pode ser nulo")
    String senha
) {
    
}
