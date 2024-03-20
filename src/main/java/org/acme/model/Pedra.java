package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Pedra {

    DIAMANTE(1,""),
    RUBI(2,""),
    ESMERALDA(3,""),
    PEROLA(4,"");

    private Integer id;
    private String label;

    Pedra(int id, String label){
        this.id = id;
        this.label = label;
    }

    public static Pedra valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (Pedra pedra : Pedra.values()) {
            if (pedra.getId().equals(id))
                return pedra;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }






    
}
