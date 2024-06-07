package org.acme.service.Corrente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.acme.dto.Corrente.CorrenteDTO;
import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.model.*;
import org.acme.repository.CorrenteRepository;
import org.acme.repository.PingenteRepository;

import java.util.List;

@ApplicationScoped
public class CorrenteServiceImpl implements CorrenteService{

    @Inject
    CorrenteRepository repository;

    @Inject
    PingenteRepository pingenteRepository;

    @Override
    @Transactional
    public CorrenteResponseDTO insert(CorrenteDTO dto) {
        Corrente novaCorrente = new Corrente();
        novaCorrente.setNome(dto.joiaDTO().nome());
        novaCorrente.setMaterial(Material.valueOf(dto.joiaDTO().idMaterial()));
        novaCorrente.setDescricao(dto.joiaDTO().descricao());
        novaCorrente.setPreco(dto.joiaDTO().preco());
        novaCorrente.setEstoque(dto.joiaDTO().estoque());
        novaCorrente.setCor(Cor.valueOf(dto.joiaDTO().idCor()));
        novaCorrente.setPeso(dto.joiaDTO().peso());
        novaCorrente.setComprimento(dto.comprimento());
        novaCorrente.setNomeImagem(dto.nomeImagem());
        novaCorrente.setTipofecho(TipoFecho.valueOf(dto.idElo()));
        novaCorrente.setTipoElo(TipoElo.valueOf(dto.idElo()));

        // Verificar se há um pingente associado
        if (dto.idPingente() != null) {
            Pingente pingente = pingenteRepository.findById(dto.idPingente());
            if (pingente != null) {
                novaCorrente.setPingente(pingente);
            } else {
                // Lançar uma exceção ou lidar com o cenário em que o pingente não é encontrado
            }
        }

        repository.persist(novaCorrente);

        return CorrenteResponseDTO.valueOf(novaCorrente);
    }

    @Override
    @Transactional
    public CorrenteResponseDTO update(CorrenteDTO dto, Long id) {
        Corrente correnteExistente = repository.findById(id);
    
        if (correnteExistente == null) {
            throw new NotFoundException("Corrente não encontrada com o ID: " + id);
        }
    
        correnteExistente.setNome(dto.joiaDTO().nome());
        correnteExistente.setMaterial(Material.valueOf(dto.joiaDTO().idMaterial()));
        correnteExistente.setDescricao(dto.joiaDTO().descricao());
        correnteExistente.setPreco(dto.joiaDTO().preco());
        correnteExistente.setEstoque(dto.joiaDTO().estoque());
        correnteExistente.setCor(Cor.valueOf(dto.joiaDTO().idCor()));
        correnteExistente.setPeso(dto.joiaDTO().peso());
        correnteExistente.setComprimento(dto.comprimento());
        correnteExistente.setNomeImagem(dto.nomeImagem());
        correnteExistente.setTipofecho(TipoFecho.valueOf(dto.idElo()));
        correnteExistente.setTipoElo(TipoElo.valueOf(dto.idElo()));
    
        // Verificar se há um pingente associado
        if (dto.idPingente() != null) {
            Pingente pingente = pingenteRepository.findById(dto.idPingente());
            if (pingente != null) {
                correnteExistente.setPingente(pingente);
            } else {
                // Lidar com o cenário em que o pingente não é encontrado
                System.out.println("Pingente não encontrado");
            }
        } else {
            correnteExistente.setPingente(null); // Remover o pingente se não houver um no DTO
        }
    
        repository.persist(correnteExistente);
    
        return CorrenteResponseDTO.valueOf(correnteExistente);
    }

    @Override
    public void delete(Long id) {
        if(!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public CorrenteResponseDTO findById(Long id) {
        return CorrenteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<CorrenteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> CorrenteResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public CorrenteResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Corrente corrente = repository.findById(id);
        corrente.setNomeImagem(nomeImagem);
        return CorrenteResponseDTO.valueOf(corrente);
    }
}
