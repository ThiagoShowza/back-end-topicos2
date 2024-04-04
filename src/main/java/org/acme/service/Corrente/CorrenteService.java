package org.acme.service.Corrente;

import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.dto.Corrente.CorrenteDTO;

import java.util.List;

public interface CorrenteService {
    public CorrenteResponseDTO insert(CorrenteDTO dto);

    public CorrenteResponseDTO update(CorrenteDTO dto, Long id);

    public void delete(Long id);

    public CorrenteResponseDTO findById(Long id);

    public List<CorrenteResponseDTO> findByAll();
}
