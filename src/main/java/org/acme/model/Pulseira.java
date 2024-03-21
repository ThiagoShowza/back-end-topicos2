package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pulseira extends Joia {

    @NotBlank(message = "Informe o comprimento da Pulseira")
    private Double comprimento;
    private String imgPulseira;
    @NotBlank(message = "Informe o tipo de Fecho")
    private TipoFecho tipoFecho;
    @NotBlank(message = "Informe o tipo de Elo")
    private TipoElo tipoElo;
    @NotBlank(message = "Informe os dados da Joia")
    private Joia joia;
    private Pingente pingente;
    
}
