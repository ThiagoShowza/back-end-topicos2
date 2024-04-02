package org.acme.service;

import java.util.List;

import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;
import org.acme.model.Cidade;
import org.acme.model.Estado;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EstadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Inject
    CidadeRepository repository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    @Transactional
    public CidadeResponseDTO insert(@Valid CidadeDTO dto) {
        Cidade novaCidade = new Cidade();
        novaCidade.setNome(dto.nome());
        Estado estado = estadoRepository.findById(dto.idEstado());
        novaCidade.setEstado(estado);

        repository.persist(novaCidade);
        return CidadeResponseDTO.valueOf(novaCidade);
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(CidadeDTO dto, Long id) {
        Cidade updateCidade = repository.findById(id);
        if (updateCidade != null) {
            updateCidade.setNome(dto.nome());
            Estado estado = estadoRepository.findById(dto.idEstado());
            updateCidade.setEstado(estado);
        } else {
            throw new NotFoundException();
        }
        return CidadeResponseDTO.valueOf(updateCidade);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        return CidadeResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CidadeResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

}
