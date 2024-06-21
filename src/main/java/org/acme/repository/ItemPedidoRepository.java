package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.ItemPedido;

import java.util.List;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {
    public List<ItemPedido> findByPessoaId(Long pessoaId) {
        return find("pedido.pessoa.id", pessoaId).list();
    }
}