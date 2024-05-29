package org.acme.resource;

import org.acme.dto.Endereco.EnderecoDTO;
import org.acme.dto.Endereco.EnderecoResponseDTO;
import org.acme.service.Endereco.EnderecoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response.Status;
import jakarta.validation.Valid;
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

@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    EnderecoService service;

    @POST
    public Response insert(@Valid EnderecoDTO dto) {
        EnderecoResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(EnderecoDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/bairro/{bairro}")
    public Response findByNome(@PathParam("bairro") String bairro) {
        return Response.ok(service.findByBairro(bairro)).build();
    }

    @GET
    @Path("/{All}")
    public Response findAll() {
        return Response.ok(service.findByAll()).build();
    }

}
