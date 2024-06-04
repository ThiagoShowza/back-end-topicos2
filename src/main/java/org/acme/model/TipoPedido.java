package org.acme.model;

import lombok.Getter;


@Getter
public enum TipoPedido {

    CORRENTE(1, "Corrente"),
    PULSEIRA(2, "Pulseira"),
    ANEL(3, "Anel");

    private Integer id;
    private String label;

    TipoPedido(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static org.acme.model.TipoPedido valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (org.acme.model.TipoPedido tipoPedido : org.acme.model.TipoPedido.values()) {
            if (tipoPedido.getId().equals(id))
                return tipoPedido;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }
}
