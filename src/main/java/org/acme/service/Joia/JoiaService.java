package org.acme.service.Joia;

import jakarta.validation.Valid;
import org.acme.dto.Joia.JoiaDTO;
import org.acme.dto.Joia.JoiaResponseDTO;

import java.util.List;

public interface JoiaService {

    public JoiaResponseDTO insert(@Valid JoiaDTO dto);

    public JoiaResponseDTO update(JoiaDTO dto, Long id);

    public void delete(Long id);

    public JoiaResponseDTO findById(Long id);

    public List<JoiaResponseDTO> findByNome(String nome);

    public List<JoiaResponseDTO> findByAll();

}