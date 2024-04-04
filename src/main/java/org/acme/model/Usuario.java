package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario extends Pessoa {

    @NotBlank(message = "O campo não pode ser nulo")
    @Email
    private String email;
    @NotBlank(message = "O campo não pode ser nulo")
    private String senha;
    private Perfil perfil;
    
}
