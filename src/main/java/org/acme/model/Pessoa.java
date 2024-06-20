package org.acme.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

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
    @CPF
    private String cpf;

    @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido")
    private String telefone;

    @Past(message = "Data de nascimento inválida")
    private LocalDate dataNascimento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> listaEndereco = new ArrayList<>();

    private String nomeImagem;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colecao> colecoes;

    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;
}
