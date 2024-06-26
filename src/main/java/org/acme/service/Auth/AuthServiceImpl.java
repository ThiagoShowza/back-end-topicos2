package org.acme.service.Auth;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.acme.dto.Cadastro.CadastroDTO;
import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Pessoa;
import org.acme.model.Usuario;
import org.acme.repository.AuthRepository;
import org.acme.repository.PessoaRepository;
import org.acme.repository.UsuarioRepository;
import org.acme.service.Hash.HashService;
import org.acme.service.Jwt.JwtService;

import java.util.ArrayList;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @Inject
    AuthRepository repository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @Override
    public LoginResponseDTO login(LoginDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());
        Usuario usuario = usuarioRepository.findByEmailAndSenha(authDTO.email(), hash);

        if (usuario == null) {
            throw new IllegalArgumentException("Email ou senha inválidos");
        }

        String token = jwtService.generateJwt(new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), usuario.getPerfil().getLabel(), null, PessoaResponseDTO.valueOf(usuario.getPessoa())));
        return new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), usuario.getPerfil().getLabel(), token, PessoaResponseDTO.valueOf(usuario.getPessoa()));
    }

    @Override
    @Transactional
    public LoginResponseDTO cadastro(CadastroDTO authDTO) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(authDTO.nome());
        novaPessoa.setCpf(authDTO.cpf());
        // Inicializa a lista de endereços como vazia
        novaPessoa.setListaEndereco(new ArrayList<>());
        pessoaRepository.persist(novaPessoa);

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(authDTO.email());
        novoUsuario.setSenha(hashService.getHashSenha(authDTO.senha()));
        novoUsuario.setPessoa(novaPessoa);
        novoUsuario.setPerfil(Perfil.USER);
        usuarioRepository.persist(novoUsuario);

        String token = jwtService.generateJwt(new LoginResponseDTO(novoUsuario.getId(), novoUsuario.getEmail(), novaPessoa.getNome(), novoUsuario.getPerfil().getLabel(), null, PessoaResponseDTO.valueOf(novaPessoa)));

        return new LoginResponseDTO(novoUsuario.getId(), novoUsuario.getEmail(), novaPessoa.getNome(), novoUsuario.getPerfil().getLabel(), token, PessoaResponseDTO.valueOf(novaPessoa));
    }

    @Override
    public LoginResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) {
            throw new ValidationException("login inválido!");
        }
        String token = jwtService.generateJwt(LoginResponseDTO.valueOf(usuario));
        return LoginResponseDTO.valueOf(usuario);
    }

    @Override
    public LoginResponseDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null) {
            throw new ValidationException("login inválido!");
        }
        String token = jwtService.generateJwt(LoginResponseDTO.valueOf(usuario));
        return LoginResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void trocarSenha(String email, String senha) {
        Log.info("Email: " + email + " senha: " + senha);
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null) {
            throw new ValidationException("Usuário não encontrado!");
        }
        String hashedPassword = hashService.getHashSenha(senha);
        usuario.setSenha(hashedPassword);
        usuarioRepository.persist(usuario);
    }
}
