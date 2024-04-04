package org.acme.dto;
import org.acme.model.Cor;
import org.acme.model.Pedra;
import org.acme.model.PedraPreciosa;

public record PedraPreciosaResponseDTO(

        Pedra pedra,
        String peso,
        Integer quantidade,
        Cor cor
) {

    public static PedraPreciosaResponseDTO valueOf(PedraPreciosa pedraPreciosa){
        return new PedraPreciosaResponseDTO(
                pedraPreciosa.getPedra(),
                pedraPreciosa.getPeso(),
                pedraPreciosa.getQuantidade(),
                pedraPreciosa.getCor());
    }
}
