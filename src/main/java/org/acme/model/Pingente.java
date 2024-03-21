package org.acme.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pingente extends Joia {

    @OneToMany(mappedBy = "pedra")
    private List<PedraPreciosa> pedraPreciosa;
    @NotBlank(message = "Informe o Material")
    private Material material;
    private Cor cor;
}
