package org.acme.service;

import java.util.List;

import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Override
    public CidadeResponseDTO insert(CidadeDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public CidadeResponseDTO update(CidadeDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    @Override
    public List<CidadeResponseDTO> findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
