package org.acme.service.Pingente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.acme.dto.Pingente.PingenteDTO;
import org.acme.dto.Pingente.PingenteResponseDTO;
import org.acme.model.Cor;
import org.acme.model.Material;
import org.acme.model.PedraPreciosa;
import org.acme.model.Pingente;
import org.acme.repository.PedraPreciosaRepository;
import org.acme.repository.PingenteRepository;

import java.util.List;

@ApplicationScoped
public class PingenteServiceImpl implements PingenteService {
    @Inject
    PingenteRepository repository;

    @Inject
    PedraPreciosaRepository pedraPreciosaRepository;

    @Override
    @Transactional
    public PingenteResponseDTO insert(PingenteDTO dto) {
        Pingente novoPingente = new Pingente();

        novoPingente.setNome(dto.nome());
        // Setando a cor e material do Pingente
        novoPingente.setCor(Cor.valueOf(dto.idCor()));
        novoPingente.setMaterial(Material.valueOf(dto.idMaterial()));

        // Buscando as pedras preciosas pelos IDs e adicionando ao Pingente
        List<PedraPreciosa> listPedraPreciosa = pedraPreciosaRepository.findByIdIfExists(dto.idPedrasPreciosas());
        if (listPedraPreciosa.size() == dto.idPedrasPreciosas().size()) {
            novoPingente.setPedraPreciosa(listPedraPreciosa);
        } else {
            System.out.println("Não foi encontrado");
        }

        // Salvando o novo pingente no banco de dados
        repository.persist(novoPingente);

        // Criando e retornando a resposta DTO
        return PingenteResponseDTO.valueOf(novoPingente);
    }

    @Override
    @Transactional
    public PingenteResponseDTO update(PingenteDTO dto, Long id) {
        Pingente pingenteExistente = repository.findById(id);
    
        if (pingenteExistente == null) {
            throw new NotFoundException("Pingente não encontrado com o ID: " + id);
        }
    
        pingenteExistente.setNome(dto.nome());
        pingenteExistente.setCor(Cor.valueOf(dto.idCor()));
        pingenteExistente.setMaterial(Material.valueOf(dto.idMaterial()));
    
        // Atualizar as pedras preciosas associadas ao pingente
        List<PedraPreciosa> listPedraPreciosa = pedraPreciosaRepository.findByIdIfExists(dto.idPedrasPreciosas());
        if (listPedraPreciosa.size() == dto.idPedrasPreciosas().size()) {
            pingenteExistente.setPedraPreciosa(listPedraPreciosa);
        } else {
            System.out.println("Alguma pedra preciosa não foi encontrada");
        }
    
        repository.persist(pingenteExistente);
    
        return PingenteResponseDTO.valueOf(pingenteExistente);
    }

    @Override
    public void delete(Long id) {
        if(!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PingenteResponseDTO findById(Long id) {
        return PingenteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PingenteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PingenteResponseDTO.valueOf(e)).toList();
    }
}
