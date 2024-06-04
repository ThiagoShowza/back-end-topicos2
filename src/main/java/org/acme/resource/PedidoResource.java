package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.Pedido.PedidoDTO;
import org.acme.dto.Pedido.PedidoResponseDTO;
import org.acme.service.Pedido.PedidoService;

import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    @POST
    public Response insert(PedidoDTO dto) {
        PedidoResponseDTO retorno = pedidoService.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(PedidoDTO dto, @PathParam("id") Long id) {
        PedidoResponseDTO retorno = pedidoService.update(dto, id);
        return Response.status(Response.Status.OK).entity(retorno).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pedidoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        PedidoResponseDTO retorno = pedidoService.findById(id);
        return Response.ok(retorno).build();
    }

    @GET
    public Response findAll() {
        List<PedidoResponseDTO> retorno = pedidoService.findAll();
        return Response.ok(retorno).build();
    }
}
