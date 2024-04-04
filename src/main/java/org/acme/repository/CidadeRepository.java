package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Cidade;

import java.util.List;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    public List<Cidade> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }
}
