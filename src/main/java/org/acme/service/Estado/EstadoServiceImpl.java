package org.acme.service.Estado;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import org.acme.dto.Estado.EstadoDTO;
import org.acme.dto.Estado.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.repository.EstadoRepository;

import java.util.List;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;

    @Override
    @Transactional
    public EstadoResponseDTO insert(@Valid EstadoDTO dto) {

        Estado novoEstado = new Estado();
        novoEstado.setNome(dto.nome());
        novoEstado.setSigla(dto.sigla());

        repository.persist(novoEstado);

        return EstadoResponseDTO.valueOf(novoEstado);
    }

    @Override
    public EstadoResponseDTO update(EstadoDTO dto, Long id) {
        Estado updateEstado = repository.findById(id);
        if (updateEstado != null) {
            updateEstado.setNome(dto.nome());
            updateEstado.setNome(dto.sigla());
        } else {
            throw new NotFoundException();
        }
        return EstadoResponseDTO.valueOf(updateEstado);

    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        return EstadoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> EstadoResponseDTO.valueOf(e)).toList();

    }

}
