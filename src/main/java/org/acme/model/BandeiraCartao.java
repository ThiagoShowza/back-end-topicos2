package org.acme.model;

import lombok.Getter;

@Getter
public enum BandeiraCartao {

    VISA(1, "Visa"),
    MASTERCARD(2, "Mastercard"),
    ELO(3, "Elo");

    private Integer id;
    private String label;

    BandeiraCartao(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static BandeiraCartao valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (BandeiraCartao bandeiraCartao : BandeiraCartao.values()) {
            if (bandeiraCartao.getId().equals(id))
                return bandeiraCartao;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

}