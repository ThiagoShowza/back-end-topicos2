package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoElo {

    GROSELHA(1, "Elo Groselha"),
    CADEADO(2, "Elo Cadeado"),
    MARINHEIRO(3, "Elo Marinheiro");

    private final Integer id;
    private final String label;

    TipoElo(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static TipoElo valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (TipoElo tipoElo : TipoElo.values()) {
            if (tipoElo.getId().equals(id))
                return tipoElo;
        }

        throw new IllegalArgumentException("Id invalido" + id);

    }

}
