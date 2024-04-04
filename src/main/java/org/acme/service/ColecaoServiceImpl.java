package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.CidadeResponseDTO;
import org.acme.dto.ColecaoDTO;
import org.acme.dto.ColecaoResponseDTO;
import org.acme.dto.PessoaResponseDTO;
import org.acme.model.Colecao;
import org.acme.repository.ColecaoRepository;
import org.acme.repository.PessoaRepository;

import java.util.List;

@ApplicationScoped
public class ColecaoServiceImpl implements ColecaoService{

    @Inject
    ColecaoRepository repository;

    @Inject
    PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public ColecaoResponseDTO insert(ColecaoDTO dto) {
        Colecao novaColecao = new Colecao();
        novaColecao.setNome(dto.nome());
        novaColecao.setDescricao(dto.descricao());
        novaColecao.setPessoa(pessoaRepository.findById(dto.pessoaId()));

        repository.persist(novaColecao);

        return ColecaoResponseDTO.valueOf(novaColecao);
    }

    @Override
    public ColecaoResponseDTO update(ColecaoDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ColecaoResponseDTO findById(Long id) {
        return ColecaoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ColecaoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> ColecaoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ColecaoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> ColecaoResponseDTO.valueOf(e)).toList();
    }
}
