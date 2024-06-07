package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ItemPedido.ItemPedidoDTO;
import org.acme.dto.ItemPedido.ItemPedidoResponseDTO;
import org.acme.service.ItemPedido.ItemPedidoService;

import java.util.List;

@Path("/itens-pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemPedidoResource {

    @Inject
    ItemPedidoService itemPedidoService;

    @POST
    public Response insert(ItemPedidoDTO dto) {
        ItemPedidoResponseDTO retorno = itemPedidoService.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(ItemPedidoDTO dto, @PathParam("id") Long id) {
        ItemPedidoResponseDTO retorno = itemPedidoService.update(dto, id);
        return Response.status(Response.Status.OK).entity(retorno).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        itemPedidoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        ItemPedidoResponseDTO retorno = itemPedidoService.findById(id);
        return Response.ok(retorno).build();
    }

    @GET
    public Response findAll() {
        List<ItemPedidoResponseDTO> retorno = itemPedidoService.findByAll();
        return Response.ok(retorno).build();
    }

    // Você pode adicionar outros métodos conforme necessário
}
