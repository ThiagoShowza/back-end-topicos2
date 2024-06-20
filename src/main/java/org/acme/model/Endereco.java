package org.acme.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Endereco extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 'XXXXX-XXX'.")
    @Column(nullable = false)
    private String cep;

    @Column(length = 8, nullable = false)
    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private Integer numero;

    @NotBlank(message = "Informe o bairro")
    @Column(length = 60, nullable = false)
    private String bairro;

    @NotBlank(message = "Informe o logradouro")
    @Column(length = 60, nullable = false)
    private String logradouro;

    @Column(length = 50)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
