package org.acme.service.Jwt;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.acme.dto.Login.LoginResponseDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(LoginResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add(dto.perfil());

        return Jwt.issuer("unitins-jwt")
                .subject(dto.email())
                .groups(roles)
                .expiresAt(expiryDate)
                .sign();
    }
}


