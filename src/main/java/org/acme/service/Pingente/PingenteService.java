package org.acme.service.Pingente;

import org.acme.dto.Pingente.PingenteDTO;
import org.acme.dto.Pingente.PingenteResponseDTO;

import java.util.List;

public interface PingenteService {
    public PingenteResponseDTO insert(PingenteDTO dto);

    public PingenteResponseDTO update(PingenteDTO dto, Long id);

    public void delete(Long id);

    public PingenteResponseDTO findById(Long id);

    public List<PingenteResponseDTO> findByAll();
}
