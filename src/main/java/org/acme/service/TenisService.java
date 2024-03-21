package org.acme.service;

import java.util.List;

import org.acme.dto.PulseiraDTO;
import org.acme.dto.TenisResponseDTO;

public interface TenisService {

    public TenisResponseDTO insert(PulseiraDTO dto);

    public TenisResponseDTO update(PulseiraDTO dto, Long id);

    public void delete(Long id);

    public TenisResponseDTO findById(Long id);

    public List<TenisResponseDTO> findByNome(String nome);

    public List<TenisResponseDTO> findByAll(); 
    
}