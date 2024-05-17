package org.acme.service.Jwt;

import org.acme.dto.Login.LoginResponseDTO;

public interface JwtService {
    
    public String generateJwt(LoginResponseDTO  dto);
    
} 