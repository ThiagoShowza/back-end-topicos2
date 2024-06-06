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
public class Pulseira extends Joia {

    @NotBlank(message = "Informe o comprimento da Pulseira")
    private Double comprimento;

    private String imgPulseira;

    @NotNull(message = "Informe o tipo de Fecho")
    private TipoFecho tipoFecho;

    @NotBlank(message = "Informe o tipo de Elo")
    private TipoElo tipoElo;

    @OneToOne(mappedBy = "pulseira", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pingente pingente;
}
