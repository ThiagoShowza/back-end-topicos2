//package org.acme.repository;
//
//import java.util.List;
//import org.acme.model.Pedido;
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import jakarta.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class PedidoRespository implements PanacheRepository<Pedido> {
//
//    public List<Pedido> findAll(String email) {
//        return find("pessoa.email = ?1", email).list();
//    }
//
//    public List<Pedido> findAll(Long idPessoa) {
//        return find("pessoa.id = ?1", idPessoa).list();
//    }
//
//}
