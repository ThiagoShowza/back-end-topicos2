package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Cidade;
import org.acme.model.Colecao;

import java.util.List;

@ApplicationScoped
public class ColecaoRepository implements PanacheRepository<Colecao> {
    public List<Colecao> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }
}
