package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import org.acme.model.Usuario;

@ApplicationScoped
public class AuthRepository implements PanacheRepository<Usuario> {
    public Usuario findByLogin(String login) {
        try {
            return find("email = ?1 ", login ).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Usuario findByEmail(String email) {
        System.out.println("Essa foi o usuario encontrado com email " + email + find("email = ?1", email).firstResult());
        return find("email = ?1", email).firstResult();
    }

}
