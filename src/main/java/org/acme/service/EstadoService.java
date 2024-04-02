package org.acme.service;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;

import jakarta.validation.Valid;

public interface EstadoService {

    public EstadoResponseDTO insert(@Valid EstadoDTO dto);

    public EstadoResponseDTO update(EstadoDTO dto, Long id);

    public void delete(Long id);

    public EstadoResponseDTO findById(Long id);

    public List<EstadoResponseDTO> findByNome(String nome);

    public List<EstadoResponseDTO> findByAll(); 
    
}