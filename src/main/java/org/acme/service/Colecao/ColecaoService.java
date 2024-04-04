package org.acme.service.Colecao;

import jakarta.validation.Valid;
import org.acme.dto.Colecao.ColecaoDTO;
import org.acme.dto.Colecao.ColecaoResponseDTO;

import java.util.List;



public interface ColecaoService {

    public ColecaoResponseDTO insert(@Valid ColecaoDTO dto);

    public ColecaoResponseDTO update(ColecaoDTO dto, Long id);

    public void delete(Long id);

    public ColecaoResponseDTO findById(Long id);

    public List<ColecaoResponseDTO> findByNome(String nome);

    public List<ColecaoResponseDTO> findByAll();

}