package org.acme.resource;

import org.acme.dto.Login.LoginDTO;
import org.acme.dto.Login.LoginResponseDTO;
import org.acme.service.Auth.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
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
}
