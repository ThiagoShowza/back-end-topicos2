package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "joia_id")
public class Anel extends Joia{

    @NotBlank(message = "Informe o tamanho do anel")
    private Double tamanho;

    private String imgAnel;

}
