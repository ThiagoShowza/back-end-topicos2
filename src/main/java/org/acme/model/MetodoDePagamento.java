package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MetodoDePagamento {

    CARTAO_DE_CREDITO(1, "Cartão de Credito"),
    CARTAO_DE_DEBITO(2, "Cartão de Debito"),
    PIX(3, "Pix");

    private final Integer id;
    private final String label;

    MetodoDePagamento(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static MetodoDePagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (MetodoDePagamento metodoDePagamento : MetodoDePagamento.values()) {
            if (metodoDePagamento.getId().equals(id))
                return metodoDePagamento;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

}
