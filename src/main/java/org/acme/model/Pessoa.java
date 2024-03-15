package org.acme.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Pessoa extends DefaultEntity {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres")
    private String senha;

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
    private List<Endereco> ListaEndereco;

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    private String nomeImagem;
}
