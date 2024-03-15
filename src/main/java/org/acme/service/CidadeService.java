package org.acme.service;

import java.util.List;

import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;



public interface CidadeService {

    public CidadeResponseDTO insert(CidadeDTO dto);

    public CidadeResponseDTO update(CidadeDTO dto, Long id);

    public void delete(Long id);

    public CidadeResponseDTO findById(Long id);

    public List<CidadeResponseDTO> findByNome(String nome);

    public List<CidadeResponseDTO> findByAll();

}