package org.acme.dto;
import org.acme.model.Cor;
import org.acme.model.PedraPreciosa;

public record PedraPreciosaResponseDTO(
        Long id,
        String peso,
        Integer quantidade,
        Cor cor
) {

    public static PedraPreciosaDTO valueOf(PedraPreciosa pedraPreciosa){
        return new PedraPreciosaDTO(
                pedraPreciosa.getPedra().getId(),
                pedraPreciosa.getPeso(),
                pedraPreciosa.getQuantidade(),
                pedraPreciosa.getCor().getId());
    }
}
