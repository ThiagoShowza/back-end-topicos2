package org.acme.dto.Login;

import org.acme.dto.Endereco.EnderecoResponseDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record LoginResponseDTO (
        Long id,
        String email,

        String nome,

        String perfil,
        String token
){
    public static LoginResponseDTO valueOf(Usuario usuario) {
        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getPessoa().getNome(),
                usuario.getPerfil().getLabel(),
                usuario.getSenha());
    }
}
