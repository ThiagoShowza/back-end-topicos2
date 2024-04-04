package org.acme.resource;

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
import org.acme.dto.Corrente.CorrenteDTO;
import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.service.Corrente.CorrenteService;

@Path("/correntes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorrenteResource {

    @Inject
    CorrenteService service;

    @POST
    public Response insert (CorrenteDTO dto){
        CorrenteResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update (CorrenteDTO dto, @PathParam("id") Long id){
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();

    }


    @GET
    public Response findAll(){
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(findById(id)).build();
    }

}
