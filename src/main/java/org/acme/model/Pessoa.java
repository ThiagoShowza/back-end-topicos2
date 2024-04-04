package org.acme.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Pessoa extends DefaultEntity {

    private String nome;

    @CPF
    private String cpf;

    @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido")
    private String telefone;

    @Past(message = "Data de nascimento inválida")
    private LocalDate DataNascimento;

    @OneToMany
    @JoinColumn(name = "id_endereco")
    private List<Endereco> listaEndereco;

    private String nomeImagem;
}
