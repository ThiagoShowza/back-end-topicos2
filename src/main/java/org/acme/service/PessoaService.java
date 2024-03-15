package org.acme.service;

import java.util.List;

import org.acme.dto.PessoaDTO;
import org.acme.dto.PessoaResponseDTO;

public interface PessoaService {

    public PessoaResponseDTO insert(PessoaDTO dto);

    public PessoaResponseDTO update(PessoaDTO dto, Long id);

    public void delete(Long id);

    public PessoaResponseDTO findById(Long id);

    public List<PessoaResponseDTO> findByNome(String nome);

    public List<PessoaResponseDTO> findByAll(); 
    
}