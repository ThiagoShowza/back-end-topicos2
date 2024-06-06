package org.acme.resource;

import io.quarkus.logging.Log;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.Auth.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.logging.Logger;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @Inject
    JsonWebToken jwt;

    @Inject
    SecurityIdentity securityIdentity;


    private static final Logger LOG = Logger.getLogger(String.valueOf(AuthResource.class));
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO authDTO) {
        try {
            LoginResponseDTO usuario = authService.login(authDTO);
            return Response.ok(usuario)
                    .header("Authorization", usuario.token())
                    .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed({"Usuario"})
    @Path("/usuarioLogado")
    public Response getUsuario() {
        try {
            String email = jwt.getSubject();
            Log.info("Pegando o usuário logado email: " + email);

            LoginResponseDTO usuarioDTO = authService.findByEmail(email);
            if (usuarioDTO == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
            }

            return Response.ok(usuarioDTO).build();
        } catch (Exception e) {
            Log.info("Deu esse erro: " + e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar o usuário logado").build();
        }
    }
}
