package org.acme.service;

import org.acme.dto.PingenteDTO;
import org.acme.dto.PingenteResponseDTO;
import org.acme.dto.PulseiraDTO;
import org.acme.dto.PulseiraResponseDTO;

import java.util.List;

public interface PulseiraService {
    public PulseiraResponseDTO insert(PulseiraDTO dto);

    public PulseiraResponseDTO update(PulseiraDTO dto, Long id);

    public void delete(Long id);

    public PulseiraResponseDTO findById(Long id);

    public List<PulseiraResponseDTO> findByAll();
}
