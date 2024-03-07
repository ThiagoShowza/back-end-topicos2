package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;


@Getter

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {

    ADM(1, "Admin"),
    USER(2, "Usuario"),
    VENDEDOR(3, "Vendedor");

    private final Integer id;
    private final String label;

    Perfil(Integer id, String label) {
        this.id = id;
        this.label = label;
    }


    public static Perfil valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (Perfil perfil : Perfil.values()) {
            if (perfil.getId().equals(id))
                return perfil;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

}