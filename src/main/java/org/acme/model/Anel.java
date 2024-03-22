package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Anel extends Joia{

    @NotBlank(message = "Informe o tamanho do anel")
    private Double tamanho;
    private String imgAnel;
    @NotBlank(message = "Informe os dados da Joia")
    private Joia joia;
    
}
