package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.ItemPedido;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {
}