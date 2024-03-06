package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco extends DefaultEntity {

    @ManyToOne
    private Cidade cidade;

    @NotBlank
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private Long cep;

    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private int numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String logradouro;

    private String complemento;

}
