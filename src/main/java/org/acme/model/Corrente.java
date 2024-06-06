package org.acme.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "joia_id")
public class Corrente extends Joia {

    @NotBlank(message = "Informe o comprimento da corrente")
    private Double comprimento;

    @NotNull(message = "Informe o tipo de Fecho")
    private TipoFecho tipofecho;

    @NotBlank(message = "Informe o tipo de Elo")
    private TipoElo tipoElo;

    private String imgCorrente;

    @OneToOne(mappedBy = "corrente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pingente pingente;

}
