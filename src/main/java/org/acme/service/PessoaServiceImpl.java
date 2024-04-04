package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.acme.dto.CidadeResponseDTO;
import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.dto.PessoaDTO;
import org.acme.dto.PessoaResponseDTO;
import org.acme.model.Cidade;
import org.acme.model.Endereco;
import org.acme.model.Pessoa;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EnderecoRepository;
import org.acme.repository.PessoaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    PessoaRepository repository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EnderecoService enderecoService;

    @Override
    @Transactional
    public PessoaResponseDTO insert(PessoaDTO dto) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(dto.nome());
        novaPessoa.setCpf(dto.cpf());
        novaPessoa.setTelefone(dto.telefone());
        novaPessoa.setDataNascimento(dto.dataNascimento());

        if (dto.listaEndereco() != null && !dto.listaEndereco().isEmpty()) {
            novaPessoa.setListaEndereco(new ArrayList<Endereco>());
            for (EnderecoDTO end : dto.listaEndereco()) {
                Endereco endereco = new Endereco();
                Cidade cidade = cidadeRepository.findById(end.idCidade());
                endereco.setCidade(cidade);
                endereco.setCep(end.cep());
                endereco.setNumero(end.numero());
                endereco.setBairro(end.bairro());
                endereco.setLogradouro(end.logradouro());
                endereco.setComplemento(end.complemento());

                novaPessoa.getListaEndereco().add(endereco);

            }
        }
        novaPessoa.setNomeImagem(dto.nomeImagem());

        repository.persist(novaPessoa);

        return PessoaResponseDTO.valueOf(novaPessoa);

    }

    @Override
    public PessoaResponseDTO update(PessoaDTO dto, Long id) {
        Pessoa pessoaUpdate = repository.findById(id);
        if (pessoaUpdate != null) {
            pessoaUpdate.setNome(dto.nome());
            pessoaUpdate.setCpf(dto.cpf());
            pessoaUpdate.setTelefone(dto.telefone());
            pessoaUpdate.setDataNascimento(dto.dataNascimento());

            if (dto.listaEndereco() != null && !dto.listaEndereco().isEmpty()) {
                pessoaUpdate.setListaEndereco(new ArrayList<Endereco>());

                for (EnderecoDTO end : dto.listaEndereco()) {
                    Endereco endereco = new Endereco();
                    Cidade cidade = cidadeRepository.findById(end.idCidade());
                    endereco.setCidade(cidade);
                    endereco.setCep(end.cep());
                    endereco.setNumero(end.numero());
                    endereco.setBairro(end.bairro());
                    endereco.setLogradouro(end.logradouro());
                    endereco.setComplemento(end.complemento());

                    pessoaUpdate.getListaEndereco().add(endereco);
                }
            }
            pessoaUpdate.setNomeImagem(dto.nomeImagem());

            repository.persist(pessoaUpdate);

        } else
            throw new NotFoundException();

        return PessoaResponseDTO.valueOf(pessoaUpdate);
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return PessoaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PessoaResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

}
