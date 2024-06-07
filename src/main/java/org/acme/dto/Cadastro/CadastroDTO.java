package org.acme.dto.Cadastro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CadastroDTO(
        @NotEmpty(message = "Informe o nome")
        String nome,
        @NotEmpty(message = "Informe o cpf")
        @CPF
        String cpf,

        @NotEmpty(message = "Informe o e-mail")
        @Email
        String email,

        @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres")
        @NotEmpty(message = "Informe a senha")
        String senha
) {
}
