package org.acme.service.Auth;

import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginDTO authDTO);
}
