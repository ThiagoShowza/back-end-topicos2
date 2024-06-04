package org.acme.dto.Joia;

import java.util.List;

import org.acme.dto.PedraPreciosa.PedraPreciosaResponseDTO;
import org.acme.model.Cor;
import org.acme.model.Joia;
import org.acme.model.Material;

public record JoiaResponseDTO(
        Long id,
        String nome,
        Material material,
        String descricao,
        List<PedraPreciosaResponseDTO> listaPedras,
        Double preco,
        Integer estoque,
        Cor cor,
        Double peso) {
    public static JoiaResponseDTO valueOf(Joia joia) {

        return new JoiaResponseDTO(
                joia.getId(),
            joia.getNome(),
            joia.getMaterial(),
            joia.getDescricao(),
            joia.getListaPedras()
                .stream()
                .map(p -> PedraPreciosaResponseDTO.valueOf(p)).toList(),
            joia.getPreco(),
            joia.getEstoque(),
            joia.getCor(),
            joia.getPeso());

    }
}