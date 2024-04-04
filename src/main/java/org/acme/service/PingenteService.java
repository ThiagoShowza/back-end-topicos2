package org.acme.service;

import org.acme.dto.PingenteDTO;
import org.acme.dto.PingenteResponseDTO;

import java.util.List;

public interface PingenteService {
    public PingenteResponseDTO insert(PingenteDTO dto);

    public PingenteResponseDTO update(PingenteDTO dto, Long id);

    public void delete(Long id);

    public PingenteResponseDTO findById(Long id);

    public List<PingenteResponseDTO> findByAll();
}
