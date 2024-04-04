package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.JoiaDTO;
import org.acme.dto.JoiaResponseDTO;
import org.acme.dto.PedraPreciosaDTO;
import org.acme.dto.PedraPreciosaResponseDTO;
import org.acme.model.*;
import org.acme.repository.JoiaRepository;
import org.acme.repository.PedraPreciosaRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JoiaServiceImpl implements JoiaService{

    @Inject
    JoiaRepository repository;

    @Inject
    PedraPreciosaRepository pedraPreciosaRepository;

    @Override
    @Transactional
    public JoiaResponseDTO insert(JoiaDTO dto) {
        Joia novaJoia = new Joia();
        novaJoia.setNome(dto.nome());
        novaJoia.setMaterial(Material.valueOf(dto.idMaterial()));
        novaJoia.setDescricao(dto.descricao());
        novaJoia.setPreco(dto.preco());
        novaJoia.setEstoque(dto.estoque());
        novaJoia.setCor(Cor.valueOf(dto.idCor()));
        novaJoia.setPeso(dto.peso());

        // Mapeamento das pedras preciosas para a nova joia
        List<PedraPreciosa> listPedraPreciosa = pedraPreciosaRepository.findByIdIfExists(dto.listaIdsPedras());
        if (listPedraPreciosa.size() == dto.listaIdsPedras().size()) {
            novaJoia.setListaPedras(listPedraPreciosa);
        } else {
            System.out.println("Não foi encontrado");
        }

        // Persiste a nova joia
        repository.persist(novaJoia);

        return JoiaResponseDTO.valueOf(novaJoia);
    }

    @Override
    public JoiaResponseDTO update(JoiaDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public JoiaResponseDTO findById(Long id) {
        return JoiaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<JoiaResponseDTO> findByNome(String nome) {
        return null;
    }

    @Override
    public List<JoiaResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> JoiaResponseDTO.valueOf(e)).toList();
    }
}
