package org.acme.dto.Login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginDTO(
    @NotEmpty(message = "Informe o e-mail")
            @Email
    String email,

    @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres")
    @NotEmpty(message = "Informe a senha")
    String senha
) {
    
}
