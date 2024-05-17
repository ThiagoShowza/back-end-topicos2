package org.acme.service.Auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.Hash.HashService;
import org.acme.service.Jwt.JwtService;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

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

        String token = jwtService.generateJwt(new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), null));
        return new LoginResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getPessoa().getNome(), token);
    }
}
