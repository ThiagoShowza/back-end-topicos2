package org.acme.service.Jwt;

import org.acme.dto.Pessoa.PessoaResponseDTO;

public interface JwtService {
    
    public String generateJwt(PessoaResponseDTO dto);
    
} 