package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Anel;

@ApplicationScoped
public class AnelRepository implements PanacheRepository<Anel> {
}
