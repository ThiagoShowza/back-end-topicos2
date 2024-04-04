package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Pulseira;


@ApplicationScoped
public class PulseiraRepository implements PanacheRepository<Pulseira> {
}
