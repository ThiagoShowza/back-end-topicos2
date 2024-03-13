package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Endereco extends DefaultEntity {

    @ManyToOne
    private Cidade cidade;

    @NotBlank
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    @Column(nullable = false)
    private Long cep;


    @Column(length = 8, nullable = false)
    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private int numero;

    @NotBlank(message = "Informe o bairro")
    @Column(length = 60, nullable = false)
    private String bairro;

    @NotBlank(message = "Informe o logradouro")
    @Column(length = 60, nullable = false)
    private String logradouro;

    @Column(length = 50)
    private String complemento;

}
