package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Pingente;


@ApplicationScoped
public class PingenteRepository implements PanacheRepository<Pingente> {
}
