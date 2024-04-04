package org.acme.service;

import jakarta.validation.Valid;
import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;
import org.acme.dto.ColecaoDTO;
import org.acme.dto.ColecaoResponseDTO;

import java.util.List;



public interface ColecaoService {

    public ColecaoResponseDTO insert(@Valid ColecaoDTO dto);

    public ColecaoResponseDTO update(ColecaoDTO dto, Long id);

    public void delete(Long id);

    public ColecaoResponseDTO findById(Long id);

    public List<ColecaoResponseDTO> findByNome(String nome);

    public List<ColecaoResponseDTO> findByAll();

}