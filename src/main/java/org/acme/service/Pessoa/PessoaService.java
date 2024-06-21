package org.acme.service.Pessoa;

import org.acme.dto.Endereco.EnderecoDTO;
import org.acme.dto.Pessoa.PessoaDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {

    public PessoaResponseDTO insert(PessoaDTO dto);

    public PessoaResponseDTO update(PessoaDTO dto, Long id);

    PessoaResponseDTO addEndereco(Long pessoaId, EnderecoDTO enderecoDTO);

    public void delete(Long id);

    public PessoaResponseDTO updateNomeImagem(Long id, String nomeImagem);

    public PessoaResponseDTO findById(Long id);

    public List<PessoaResponseDTO> findByNome(String nome);

    public List<PessoaResponseDTO> findByAll(); 
    
}