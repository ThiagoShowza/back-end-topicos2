package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.PedraPreciosa;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PedraPreciosaRepository implements PanacheRepository<PedraPreciosa> {
    public List<PedraPreciosa> findByIdIfExists( List<Long> idGames) {
        List<PedraPreciosa> listPedraPreciosa =  new ArrayList<>();
        for(Long id : idGames){
            PedraPreciosa pedraPreciosa = this.findById(id);
            if (pedraPreciosa != null){
                listPedraPreciosa.add(pedraPreciosa);
            }
        }
        return listPedraPreciosa;
    }
}
