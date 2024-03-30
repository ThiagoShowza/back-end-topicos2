package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Corrente extends Joia {

    @NotBlank(message = "Informe o comprimento da corrente")
    private Double comprimento;
    @NotBlank(message = "Informe o tipo de Fecho")
    private TipoFecho tipofecho;
    @NotBlank(message = "Informe o tipo de Elo")
    private TipoElo tipoElo;
    private String imgCorrente;
    private Pingente pingente;

}
