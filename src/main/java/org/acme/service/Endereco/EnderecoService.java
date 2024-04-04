package org.acme.service.Endereco;

import org.acme.dto.Endereco.EnderecoDTO;
import org.acme.dto.Endereco.EnderecoResponseDTO;

import java.util.List;

public interface EnderecoService {
    
    public EnderecoResponseDTO insert(EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);
    
    public List<EnderecoResponseDTO> findByBairro(String nome);

    public List<EnderecoResponseDTO> findByAll();
}