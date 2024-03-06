package org.acme.model;

public enum Cor{

    AZUL(1, "Azul"),
    BRANCO(2, "Branco"),
    PRETO(3, "Preto"),
    VERDE(4, "Verde"),
    AMARELO(5, "Amarelo"),
    VERMELHO(6, "Vermelho");

    private int id;
    private String label;

    Cor(int id, String label){
        this.id = id;
        this.label = label;
    }
    

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
