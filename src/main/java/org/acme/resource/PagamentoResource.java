package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.acme.dto.Pagamento.PagamentoDTO;
import org.acme.dto.Pagamento.PagamentoResponseDTO;
import org.acme.service.Pagamento.PagamentoService;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    PagamentoService service;

    @POST
    @RolesAllowed({"Admin", "Usuario"})
    @Transactional
    public Response insert(PagamentoDTO dto) {
        PagamentoResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response update(PagamentoDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed({"Admin"})
    public Response findAll() {
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Admin", "Usuario"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }
}
