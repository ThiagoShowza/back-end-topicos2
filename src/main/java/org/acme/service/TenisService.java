package org.acme.service;

import java.util.List;

import org.acme.dto.TenisDTO;
import org.acme.dto.TenisResponseDTO;

public interface TenisService {

    public TenisResponseDTO insert(TenisDTO dto);

    public TenisResponseDTO update(TenisDTO dto, Long id);

    public void delete(Long id);

    public TenisResponseDTO findById(Long id);

    public List<TenisResponseDTO> findByNome(String nome);

    public List<TenisResponseDTO> findByAll(); 
    
}