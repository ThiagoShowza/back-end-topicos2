package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoFecho {

    GANCHO(1, "Fecho de Gancho"),
    MOLA(2, "Fecho de Mola"),
    FECHO(3, "Fecho de Fecho");

    private final Integer id;
    private final String label;

    TipoFecho(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static TipoFecho valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (TipoFecho tipoFecho : TipoFecho.values()) {
            if (tipoFecho.getId().equals(id))
                return tipoFecho;
        }

        throw new IllegalArgumentException("Id invalido" + id);

    }

}
