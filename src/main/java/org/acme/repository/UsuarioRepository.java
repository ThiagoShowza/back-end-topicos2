package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Usuario;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public Usuario findByEmailAndSenha(String email, String senha) {
        System.out.println("Essa foi o usuario encontrado com email " + email + " e senha: " + senha + find("email = ?1 AND senha = ?2", email, senha).firstResult());
        return find("email = ?1 AND senha = ?2", email, senha).firstResult();
    }
}
