package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Tamanho {

    TRINTA_OITO(1, 38),
    TRINTA_NOVE(2, 39),
    QUARENTA(3, 40),
    QUARENTA_E_UM(4, 41),
    QUARENTA_E_DOIS(5, 42),
    QUARENTA_E_TRES(6, 43),
    QUARENTA_E_QUATRO(7, 44),
    QUARENTA_E_CINCO(8, 45);

    private final Integer id;
    private final Integer numero;


    private Tamanho(Integer id, Integer numero) {
        this.id = id;
        this.numero = numero;
    }

    public static Tamanho valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (Tamanho tamanho : Tamanho.values()) {
            if (tamanho.getId().equals(id))
                return tamanho;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

}
