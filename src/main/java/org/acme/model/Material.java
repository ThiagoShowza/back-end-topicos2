package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Material {

    OURO(1,""),
    PRATA(2,""),
    BRONZE(3,""),
    AÇO(4,"");

    private final Integer id;
    private final String label;


    private Material(Integer id, String label) {
        this.id = id;
        this.label = label;
    }


    public static Material valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (Material material : Material.values()) {
            if (material.getId().equals(id))
                return material;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }


    


    
}
