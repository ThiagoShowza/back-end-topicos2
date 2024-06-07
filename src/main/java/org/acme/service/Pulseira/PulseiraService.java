package org.acme.service.Pulseira;

import org.acme.dto.Pulseira.PulseiraDTO;
import org.acme.dto.Pulseira.PulseiraResponseDTO;

import java.util.List;

public interface PulseiraService {
    public PulseiraResponseDTO insert(PulseiraDTO dto);

    public PulseiraResponseDTO update(PulseiraDTO dto, Long id);

    public PulseiraResponseDTO updateNomeImagem(Long id, String nomeImagem);

    public void delete(Long id);

    public PulseiraResponseDTO findById(Long id);

    public List<PulseiraResponseDTO> findByAll();
}
