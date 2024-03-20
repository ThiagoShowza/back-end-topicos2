package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PedraPreciosa extends DefaultEntity{
    
    @NotBlank(message = "Informe qual tipo de pedra")
    private Pedra pedra;
    @NotBlank(message = "Informe o peso da pedra")
    private String peso;
    @NotBlank(message = "Informe a quantidade de pedras")
    private Integer quantidade;
    @NotBlank(message = "Informe a cor da pedra")
    private Cor cor;
    
}
