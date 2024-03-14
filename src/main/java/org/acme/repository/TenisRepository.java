package org.acme.repository;

import java.util.List;
import org.acme.model.Tenis;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TenisRepository implements PanacheRepository<Tenis> {
    public List<Tenis> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }

}
