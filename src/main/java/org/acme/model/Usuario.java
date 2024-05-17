package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario extends DefaultEntity{
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres")
    private String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
