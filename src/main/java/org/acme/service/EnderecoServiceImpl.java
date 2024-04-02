package org.acme.service;

import java.util.List;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Cidade;
import org.acme.model.Endereco;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EnderecoRespository;
import org.acme.repository.EstadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject 
    EnderecoRespository repository;

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
    public EnderecoResponseDTO update(EnderecoDTO dto, Long id) {
        Endereco EnderecoUpdate = repository.findById(id);


    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<EnderecoResponseDTO> findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
