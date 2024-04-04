package org.acme.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pingente extends DefaultEntity{

    @OneToMany(mappedBy = "pedra")
    private List<PedraPreciosa> pedraPreciosa;

    @NotBlank(message = "Informe o Material")
    private Material material;

    @NotBlank(message = "Informe a cor")
    private Cor cor;

    @OneToOne
    @JoinColumn(name = "pulseira_id")
    private Pulseira pulseira;
}
