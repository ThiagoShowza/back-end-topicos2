package org.acme.service.Anel;

import org.acme.dto.Anel.AnelDTO;
import org.acme.dto.Anel.AnelResponseDTO;

import java.util.List;

public interface AnelService {
    public AnelResponseDTO insert(AnelDTO dto);

    public AnelResponseDTO update(AnelDTO dto, Long id);

    public void delete(Long id);

    public AnelResponseDTO findById(Long id);

    public List<AnelResponseDTO> findByAll();
}
