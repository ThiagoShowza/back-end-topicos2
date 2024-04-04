//package org.acme.repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.acme.model.Pagamento;
//
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import jakarta.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class PagamentoRespository implements PanacheRepository<Pagamento> {
//
//    public List<Pagamento> findByDataPagamento(LocalDate dataPagamento) {
//        return find("dataPagamento = ?1", dataPagamento).list();
//    }
//}
