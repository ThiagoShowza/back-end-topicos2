package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

import java.io.File;
import java.io.IOException;

import org.acme.dto.Anel.AnelDTO;
import org.acme.dto.Anel.AnelResponseDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.form.ImagemForm;
import org.acme.service.Anel.AnelFileService;
import org.acme.service.Anel.AnelService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/aneis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnelResource {

    @Inject
    AnelService service;

    @Inject
    AnelFileService fileService;



    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insert (AnelDTO dto){
        AnelResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response update (AnelDTO dto, @PathParam("id") Long id){
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @DELETE
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/upload/imagem/{id}")
    @RolesAllowed({ "Admin" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImagemForm form, @PathParam("id") Long id) throws IOException {
        String nomeImagem;
        nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
        AnelResponseDTO anelDTO = service.findById(id);
        anelDTO = service.updateNomeImagem(anelDTO.id(), nomeImagem);

        return Response.ok(anelDTO).build();

    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        // Obtain the File object corresponding to the requested image name
        File file = fileService.obter(nomeImagem);

        // Create a ResponseBuilder with the file content
        ResponseBuilder response = Response.ok(fileService.obter(nomeImagem));

        // Set the Content-Disposition header to specify the filename for the downloaded
        // file
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);

        // Build and return the Response object
        return response.build();
    }
  



    @GET
    @RolesAllowed({"Usuario", "Admin"})
    public Response findAll(){
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(service.findById(id)).build();
    }

}
