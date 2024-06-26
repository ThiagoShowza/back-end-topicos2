package org.acme.service.Auth;

import org.acme.dto.Cadastro.CadastroDTO;
import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginDTO authDTO);

    LoginResponseDTO cadastro(CadastroDTO authDTO);

    public LoginResponseDTO findByLogin(String login);

    public LoginResponseDTO findByEmail(String email);

    public void trocarSenha(String email, String senha);
}
