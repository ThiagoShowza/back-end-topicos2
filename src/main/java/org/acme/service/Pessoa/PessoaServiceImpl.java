package org.acme.service.Pessoa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.Pessoa.PessoaDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Pessoa;
import org.acme.repository.PessoaRepository;

import java.util.List;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    PessoaRepository repository;

    @Override
    @Transactional
    public PessoaResponseDTO insert(PessoaDTO dto) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(dto.nome());
        novaPessoa.setEmail(dto.email());
        novaPessoa.setCpf(dto.cpf());
        novaPessoa.setPerfil(Perfil.valueOf(dto.idperfil()));
        novaPessoa.setDataNascimento(dto.dataNascimento());

        repository.persist(novaPessoa);

        return PessoaResponseDTO.valueOf(novaPessoa);
    }

    @Override
    public PessoaResponseDTO update(PessoaDTO dto, Long id) {
        return null;
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
}
