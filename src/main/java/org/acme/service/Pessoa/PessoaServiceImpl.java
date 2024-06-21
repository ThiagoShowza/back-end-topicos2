package org.acme.service.Pessoa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.acme.dto.Endereco.EnderecoDTO;
import org.acme.dto.Pessoa.PessoaDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.model.Endereco;
import org.acme.model.Perfil;
import org.acme.model.Pessoa;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EnderecoRepository;
import org.acme.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    PessoaRepository repository;

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EnderecoRepository enderecoRepository;


    @Override
    @Transactional
    public PessoaResponseDTO insert(PessoaDTO dto) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(dto.nome());
        novaPessoa.setCpf(dto.cpf());
        novaPessoa.setDataNascimento(dto.dataNascimento());
        novaPessoa.setTelefone(dto.telefone());
        novaPessoa.setNomeImagem(dto.nomeImagem());

        List<Endereco> enderecos = dto.ListaEndereco().stream()
                .map(enderecoDTO -> {
                    Endereco endereco = new Endereco();
                    endereco.setCidade(cidadeRepository.findById(enderecoDTO.idCidade()));
                    endereco.setCep(enderecoDTO.cep());
                    endereco.setNumero(enderecoDTO.numero());
                    endereco.setBairro(enderecoDTO.bairro());
                    endereco.setLogradouro(enderecoDTO.logradouro());
                    endereco.setComplemento(enderecoDTO.complemento());
                    endereco.setPessoa(novaPessoa); // Associa o endereço à nova pessoa
                    return endereco;
                })
                .collect(Collectors.toList());

        novaPessoa.setListaEndereco(enderecos);

        repository.persist(novaPessoa);

        return PessoaResponseDTO.valueOf(novaPessoa);
    }


    @Override
    @Transactional
    public PessoaResponseDTO update(PessoaDTO dto, Long id) {
        Pessoa pessoaExistente = repository.findById(id);
        if (pessoaExistente == null) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
        }

        pessoaExistente.setNome(dto.nome());
        pessoaExistente.setCpf(dto.cpf());
        pessoaExistente.setDataNascimento(dto.dataNascimento());
        pessoaExistente.setTelefone(dto.telefone());
        pessoaExistente.setNomeImagem(dto.nomeImagem());

        // Atualizar os endereços
        List<Endereco> enderecos = dto.ListaEndereco().stream()
                .map(enderecoDTO -> {
                    Endereco endereco = pessoaExistente.getListaEndereco().stream()
                            .filter(e -> e.getId().equals(enderecoDTO.idCidade()))
                            .findFirst()
                            .orElse(new Endereco());
                    endereco.setCidade(cidadeRepository.findById(enderecoDTO.idCidade()));
                    endereco.setCep(enderecoDTO.cep());
                    endereco.setNumero(enderecoDTO.numero());
                    endereco.setBairro(enderecoDTO.bairro());
                    endereco.setLogradouro(enderecoDTO.logradouro());
                    endereco.setComplemento(enderecoDTO.complemento());
                    endereco.setPessoa(pessoaExistente); // Associa o endereço à pessoa existente
                    return endereco;
                })
                .collect(Collectors.toList());

        pessoaExistente.setListaEndereco(enderecos);

        repository.persist(pessoaExistente);

        return PessoaResponseDTO.valueOf(pessoaExistente);
    }

    @Override
    @Transactional
    public PessoaResponseDTO addEndereco(Long pessoaId, EnderecoDTO enderecoDTO) {
        Pessoa pessoa = repository.findById(pessoaId);
        if (pessoa == null) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + pessoaId);
        }

        Endereco endereco;
        if (enderecoDTO.idCidade() != null) {
            endereco = enderecoRepository.findById(enderecoDTO.idCidade());
            if (endereco == null) {
                throw new EntityNotFoundException("Endereço não encontrado com o ID: " + enderecoDTO.idCidade());
            }
        } else {
            endereco = new Endereco();
            endereco.setCidade(cidadeRepository.findById(enderecoDTO.idCidade()));
            endereco.setCep(enderecoDTO.cep());
            endereco.setNumero(enderecoDTO.numero());
            endereco.setBairro(enderecoDTO.bairro());
            endereco.setLogradouro(enderecoDTO.logradouro());
            endereco.setComplemento(enderecoDTO.complemento());
        }

        endereco.setPessoa(pessoa); // Associa o endereço à pessoa
        pessoa.getListaEndereco().add(endereco);

        enderecoRepository.persist(endereco);
        repository.persist(pessoa);

        return PessoaResponseDTO.valueOf(pessoa);
    }



    @Override
    public void delete(Long id) {

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

    @Override
    public PessoaResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Pessoa pessoa = repository.findById(id);
        pessoa.setNomeImagem(nomeImagem);
        return PessoaResponseDTO.valueOf(pessoa);
    }
}
