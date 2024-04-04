package org.acme.service.PedraPreciosa;

import jakarta.validation.Valid;
import org.acme.dto.PedraPreciosa.PedraPreciosaDTO;
import org.acme.dto.PedraPreciosa.PedraPreciosaResponseDTO;

import java.util.List;



public interface PedraPreciosaService {

    public PedraPreciosaResponseDTO insert(@Valid PedraPreciosaDTO dto);

    public PedraPreciosaResponseDTO update(PedraPreciosaDTO dto, Long id);

    public void delete(Long id);

    public PedraPreciosaResponseDTO findById(Long id);

    public List<PedraPreciosaResponseDTO> findByNome(String nome);

    public List<PedraPreciosaResponseDTO> findByAll();

}