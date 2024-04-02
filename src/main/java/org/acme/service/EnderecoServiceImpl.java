package org.acme.service;

import java.util.List;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Cidade;
import org.acme.model.Endereco;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EnderecoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject 
    EnderecoRepository repository;

    @Inject
    CidadeRepository cidadeRepository;

    @Override
    @Transactional
    public EnderecoResponseDTO insert(EnderecoDTO dto) {
    
        Endereco novoEndereco = new Endereco();
        Cidade cidade = cidadeRepository.findById(dto.idCidade());
        novoEndereco.setCidade(cidade);
        novoEndereco.setCep(dto.cep());
        novoEndereco.setNumero(dto.numero());
        novoEndereco.setBairro(dto.bairro());
        novoEndereco.setLogradouro(dto.logradouro());
        novoEndereco.setComplemento(dto.complemento());
        
        repository.persist(novoEndereco);

        return EnderecoResponseDTO.valueOf(novoEndereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(EnderecoDTO dto, Long id) {
        Endereco enderecoUpdate = repository.findById(id);

            if(enderecoUpdate != null){
                Cidade cidade = cidadeRepository.findById(dto.idCidade());
                enderecoUpdate.setCidade(cidade);
                enderecoUpdate.setCep(dto.cep());
                enderecoUpdate.setNumero(dto.numero());
                enderecoUpdate.setBairro(dto.bairro());
                enderecoUpdate.setLogradouro(dto.logradouro());
                enderecoUpdate.setComplemento(dto.complemento());
            }
            else
            throw new NotFoundException();

            return EnderecoResponseDTO.valueOf(enderecoUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!repository.deleteById(id))
        throw new NotFoundException();

    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<EnderecoResponseDTO> findByBairro(String bairro) {
        return repository.findByBairro(bairro).stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();

    }
    
}
