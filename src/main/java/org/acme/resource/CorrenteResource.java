package org.acme.resource;

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

import org.acme.dto.Corrente.CorrenteDTO;
import org.acme.dto.Corrente.CorrenteResponseDTO;
import org.acme.form.ImagemForm;
import org.acme.service.Corrente.CorrenteFileService;
import org.acme.service.Corrente.CorrenteService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/correntes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorrenteResource {

    @Inject
    CorrenteService service;

    @Inject
    CorrenteFileService fileService;

    @POST
    @Transactional
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


    @PATCH
    @Path("/upload/imagem/{id}")
    // @RolesAllowed({ "Admin" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImagemForm form, @PathParam("id") Long id) throws IOException {
        String nomeImagem;
        nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
        CorrenteResponseDTO correnteDTO = service.findById(id);
        correnteDTO = service.updateNomeImagem(correnteDTO.id(), nomeImagem);

        return Response.ok(correnteDTO).build();

    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    // @RolesAllowed({ "Admin" })
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
    public Response findAll(){
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(service.findById(id)).build();
    }

}
