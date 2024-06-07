package org.acme.service.Anel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.acme.dto.Anel.AnelDTO;
import org.acme.dto.Anel.AnelResponseDTO;
import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.model.Anel;
import org.acme.model.Cor;
import org.acme.model.Material;
import org.acme.repository.AnelRepository;

import java.util.List;

@ApplicationScoped
public class AnelServiceimpl implements AnelService {

    @Inject
    AnelRepository repository;

    @Override
    @Transactional
    public AnelResponseDTO insert(AnelDTO dto) {
        Anel novoAnel = new Anel();
        novoAnel.setNome(dto.joiaDTO().nome());
        novoAnel.setMaterial(Material.valueOf(dto.joiaDTO().idMaterial()));
        novoAnel.setDescricao(dto.joiaDTO().descricao());
        novoAnel.setPreco(dto.joiaDTO().preco());
        novoAnel.setEstoque(dto.joiaDTO().estoque());
        novoAnel.setCor(Cor.valueOf(dto.joiaDTO().idCor()));
        novoAnel.setPeso(dto.joiaDTO().peso());
        novoAnel.setTamanho(dto.tamanho());
        novoAnel.setNomeImagem(dto.nomeImagem());

        repository.persist(novoAnel);

        return AnelResponseDTO.valueOf(novoAnel);
    }

    @Override
    @Transactional
    public AnelResponseDTO update(AnelDTO dto, Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public AnelResponseDTO findById(Long id) {
        return AnelResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<AnelResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> AnelResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public AnelResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Anel anel = repository.findById(id);
        anel.setNomeImagem(nomeImagem);
        return AnelResponseDTO.valueOf(anel);
    }
}
