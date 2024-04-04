package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Pessoa;

import java.util.List;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {
    public List<Pessoa> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }
}
