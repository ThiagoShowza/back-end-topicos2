package org.acme.service.Pulseira;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.acme.dto.Pulseira.PulseiraDTO;
import org.acme.dto.Pulseira.PulseiraResponseDTO;
import org.acme.model.*;
import org.acme.repository.PingenteRepository;
import org.acme.repository.PulseiraRepository;

import java.util.List;

@ApplicationScoped
public class PulseiraServiceImpl implements PulseiraService {

    @Inject
    PulseiraRepository repository;

    @Inject
    PingenteRepository pingenteRepository;

    @Override
    @Transactional
    public PulseiraResponseDTO insert(PulseiraDTO dto) {
        Pulseira novaPulseira = new Pulseira();
        novaPulseira.setNome(dto.joiaDTO().nome());
        novaPulseira.setMaterial(Material.valueOf(dto.joiaDTO().idMaterial()));
        novaPulseira.setDescricao(dto.joiaDTO().descricao());
        novaPulseira.setPreco(dto.joiaDTO().preco());
        novaPulseira.setEstoque(dto.joiaDTO().estoque());
        novaPulseira.setCor(Cor.valueOf(dto.joiaDTO().idCor()));
        novaPulseira.setPeso(dto.joiaDTO().peso());
        novaPulseira.setComprimento(dto.comprimento());
        novaPulseira.setNomeImagem(dto.nomeImagem());
        novaPulseira.setTipoFecho(TipoFecho.valueOf(dto.idElo()));
        novaPulseira.setTipoElo(TipoElo.valueOf(dto.idElo()));

        // Verificar se há um pingente associado
        if (dto.idPingente() != null) {
            Pingente pingente = pingenteRepository.findById(dto.idPingente());
            if (pingente != null) {
                novaPulseira.setPingente(pingente);
            } else {
                // Lançar uma exceção ou lidar com o cenário em que o pingente não é encontrado
            }
        }

        repository.persist(novaPulseira);

        return PulseiraResponseDTO.valueOf(novaPulseira);
    }

    @Override
    @Transactional
    public PulseiraResponseDTO update(PulseiraDTO dto, Long id) {
        Pulseira pulseiraExistente = repository.findById(id);
        
        if (pulseiraExistente == null) {
            throw new NotFoundException("Pulseira não encontrada com o ID: " + id);
        }
    
        pulseiraExistente.setNome(dto.joiaDTO().nome());
        pulseiraExistente.setMaterial(Material.valueOf(dto.joiaDTO().idMaterial()));
        pulseiraExistente.setDescricao(dto.joiaDTO().descricao());
        pulseiraExistente.setPreco(dto.joiaDTO().preco());
        pulseiraExistente.setEstoque(dto.joiaDTO().estoque());
        pulseiraExistente.setCor(Cor.valueOf(dto.joiaDTO().idCor()));
        pulseiraExistente.setPeso(dto.joiaDTO().peso());
        pulseiraExistente.setComprimento(dto.comprimento());
        pulseiraExistente.setNomeImagem(dto.nomeImagem());
        pulseiraExistente.setTipoFecho(TipoFecho.valueOf(dto.idElo()));
        pulseiraExistente.setTipoElo(TipoElo.valueOf(dto.idElo()));
    
        // Verificar se há um pingente associado
        if (dto.idPingente() != null) {
            Pingente pingente = pingenteRepository.findById(dto.idPingente());
            if (pingente != null) {
                pulseiraExistente.setPingente(pingente);
            } else {
                // Lançar uma exceção ou lidar com o cenário em que o pingente não é encontrado
            }
        } else {
            pulseiraExistente.setPingente(null); // Remover o pingente se não houver um no DTO
        }
    
        repository.persist(pulseiraExistente);
    
        return PulseiraResponseDTO.valueOf(pulseiraExistente);
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PulseiraResponseDTO findById(Long id) {
        return PulseiraResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PulseiraResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PulseiraResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PulseiraResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Pulseira pulseira = repository.findById(id);
        pulseira.setNomeImagem(nomeImagem);
        return PulseiraResponseDTO.valueOf(pulseira);
    }
}
