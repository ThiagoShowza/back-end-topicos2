package org.acme.service.Auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ValidationException;
import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.model.Usuario;
import org.acme.repository.AuthRepository;
import org.acme.repository.UsuarioRepository;
import org.acme.service.Hash.HashService;
import org.acme.service.Jwt.JwtService;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @Inject
    AuthRepository repository;
    @Inject
    UsuarioRepository usuarioRepository;

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

        String token = jwtService.generateJwt(new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), usuario.getPerfil().getLabel(), usuario.getSenha()));
        return new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), usuario.getPerfil().getLabel(), token);
    }

    @Override
    public LoginResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null)
            throw new ValidationException("login inválido!");

        return LoginResponseDTO.valueOf(usuario);
    }

    @Override
    public LoginResponseDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null)
            throw new ValidationException("login inválido!");

        return LoginResponseDTO.valueOf(usuario);
    }
}
