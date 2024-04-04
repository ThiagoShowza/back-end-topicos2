package org.acme.service.Pulseira;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
        novaPulseira.setImgPulseira(dto.imgPulseira());
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
    public PulseiraResponseDTO update(PulseiraDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PulseiraResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PulseiraResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PulseiraResponseDTO.valueOf(e)).toList();
    }
}
