package org.acme.service;

import org.acme.dto.PessoaResponseDTO;

public interface JwtService {
    
    public String generateJwt(PessoaResponseDTO dto);
    
} 