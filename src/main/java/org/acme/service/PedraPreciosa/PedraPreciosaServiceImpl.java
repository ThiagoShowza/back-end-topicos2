package org.acme.service.PedraPreciosa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.PedraPreciosa.PedraPreciosaDTO;
import org.acme.dto.PedraPreciosa.PedraPreciosaResponseDTO;
import org.acme.model.Cor;
import org.acme.model.Pedra;
import org.acme.model.PedraPreciosa;
import org.acme.repository.PedraPreciosaRepository;

import java.util.List;

@ApplicationScoped
public class PedraPreciosaServiceImpl implements PedraPreciosaService {

    @Inject
    PedraPreciosaRepository repository;
    @Override
    @Transactional
    public PedraPreciosaResponseDTO insert(PedraPreciosaDTO dto) {
        PedraPreciosa novaPedraPreciosa = new PedraPreciosa();
        novaPedraPreciosa.setPedra(Pedra.valueOf(dto.idPedra()));
        novaPedraPreciosa.setPeso(dto.peso());
        novaPedraPreciosa.setQuantidade(dto.quantidade());
        novaPedraPreciosa.setCor(Cor.valueOf(dto.idCor()));

        repository.persist(novaPedraPreciosa);

        return PedraPreciosaResponseDTO.valueOf(novaPedraPreciosa);
    }

    @Override
    public PedraPreciosaResponseDTO update(PedraPreciosaDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PedraPreciosaResponseDTO findById(Long id) {
        return PedraPreciosaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PedraPreciosaResponseDTO> findByNome(String nome) {
        return null;
    }

    @Override
    public List<PedraPreciosaResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PedraPreciosaResponseDTO.valueOf(e)).toList();
    }
}
