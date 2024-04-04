package org.acme.service.Corrente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.Corrente.CorrenteDTO;
import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.dto.Pulseira.PulseiraResponseDTO;
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
        novaCorrente.setImgCorrente(dto.imgPulseira());
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
    public CorrenteResponseDTO update(CorrenteDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CorrenteResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<CorrenteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> CorrenteResponseDTO.valueOf(e)).toList();
    }
}
