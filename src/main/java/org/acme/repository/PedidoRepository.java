package org.acme.repository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.acme.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findAll(String email) {
        return find("pessoa.email = ?1", email).list();
    }

    @Transactional
    public Pedido findByPessoaId(Long pessoaId) {
        return find("pessoa.id", pessoaId).firstResult();
    }

}
