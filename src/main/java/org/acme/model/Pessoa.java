package org.acme.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Pessoa extends DefaultEntity {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido")
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @Past(message = "Data de nascimento inválida")
    private LocalDate DataNascimento;

    @OneToMany
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    private String nomeImagem;
}
