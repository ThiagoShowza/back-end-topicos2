package org.acme.resource;

import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.dto.Pedido.PedidoDTO;
import org.acme.dto.Pedido.PedidoResponseDTO;
import org.acme.service.Auth.AuthService;
import org.acme.service.Pedido.PedidoService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    @Inject
    AuthService authService;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(PedidoDTO dto) {
        PedidoResponseDTO retorno = pedidoService.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @GET
    @Path("/usuarioLogado")
    @RolesAllowed({"Admin", "Usuario"})
    public Response findPedidosUsuarioLogado() {
        String email = jwt.getSubject();
        Log.info("Pegando o usuário logado email: " + email);

        LoginResponseDTO usuarioDTO = authService.findByEmail(email);
        if (usuarioDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
        List<PedidoResponseDTO> retorno = pedidoService.findPedidosUsuarioLogado(email);
        return Response.ok(retorno).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response update(PedidoDTO dto, @PathParam("id") Long id) {
        PedidoResponseDTO retorno = pedidoService.update(dto, id);
        return Response.status(Response.Status.OK).entity(retorno).build();
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pedidoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        PedidoResponseDTO retorno = pedidoService.findById(id);
        return Response.ok(retorno).build();
    }

    @GET
    @RolesAllowed({"Admin", "Usuario"})
    public Response findAll() {
        List<PedidoResponseDTO> retorno = pedidoService.findAll();
        return Response.ok(retorno).build();
    }
}
