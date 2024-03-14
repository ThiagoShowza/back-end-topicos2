package org.acme.repository;

import java.util.List;

import org.acme.model.Endereco;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRespository implements PanacheRepository<Endereco>{

    public List<Endereco> findById(String cidade){
        return find("pessoa.id = ?1",cidade).list(); 
    }
    
}
