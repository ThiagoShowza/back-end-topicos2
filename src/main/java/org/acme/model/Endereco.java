package org.acme.model;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Endereco extends DefaultEntity{

    @ManyToOne
    private Cidade cidade;
   
    @NotBlank
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private Long cep;

    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private int numero;
    
    private String bairro;
    private String complemento;
    private String logradouro;
    

    
}
