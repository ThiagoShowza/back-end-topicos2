package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Endereco;

import java.util.List;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco>{

    public List<Endereco> findById(String cidade){
        return find("cidade.id = ?1",cidade).list(); 
    }

    public List<Endereco> findByBairro(String bairro) {
        return find("UPPER(bairro) LIKE UPPER(?1)", "%" + bairro + "%").list();
    }


    
}
