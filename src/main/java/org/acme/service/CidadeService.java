package org.acme.service;

import jakarta.validation.Valid;
import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;

import java.util.List;



public interface CidadeService {

    public CidadeResponseDTO insert(@Valid CidadeDTO dto);

    public CidadeResponseDTO update(CidadeDTO dto, Long id);

    public void delete(Long id);

    public CidadeResponseDTO findById(Long id);

    public List<CidadeResponseDTO> findByNome(String nome);

    public List<CidadeResponseDTO> findByAll();

}