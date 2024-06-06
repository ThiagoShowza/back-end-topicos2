package org.acme.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pingente extends DefaultEntity{

    @OneToMany(mappedBy = "pedra")
    private List<PedraPreciosa> pedraPreciosa;


    @NotBlank(message = "Informe o nome")
    private String nome;


    @NotNull(message = "Informe o Material")
    private Material material;

    @NotNull(message = "Informe a cor")
    private Cor cor;

    @OneToOne
    @JoinColumn(name = "pulseira_id", nullable = true)
    private Pulseira pulseira;

    @OneToOne
    @JoinColumn(name = "corrente_id", nullable = true)
    private Corrente corrente;
}
