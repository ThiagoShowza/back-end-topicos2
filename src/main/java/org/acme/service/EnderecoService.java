package org.acme.service;

import java.util.List;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;

public interface EnderecoService {
    
    public EnderecoResponseDTO insert(EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);
    
    public List<EnderecoResponseDTO> findByBairro(String nome);

    public List<EnderecoResponseDTO> findByAll();
}