package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Cor {

    AZUL(1, "Azul"),
    BRANCO(2, "Branco"),
    PRETO(3, "Preto"),
    VERDE(4, "Verde"),
    AMARELO(5, "Amarelo"),
    VERMELHO(6, "Vermelho");

    private Integer id;
    private String label;

    Cor(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static Cor valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (Cor cor : Cor.values()) {
            if (cor.getId().equals(id))
                return cor;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

}
