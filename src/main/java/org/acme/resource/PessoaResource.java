package org.acme.resource;
import java.io.File;
import java.io.IOException;
import jakarta.annotation.security.RolesAllowed;
import org.acme.dto.Pessoa.PessoaDTO;
import org.acme.dto.Pessoa.PessoaResponseDTO;
import org.acme.form.ImagemForm;

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

import org.acme.service.Pessoa.PessoaFileService;
import org.acme.service.Pessoa.PessoaService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService service;

    @Inject
    PessoaFileService fileService;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"Admin"})
    public Response insert (PessoaDTO dto){
       PessoaResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response update(PessoaDTO dto, @PathParam("id") Long id) {
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
    public Response findAll(){
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(findById(id)).build();
    }

    @GET
    @RolesAllowed({"Admin", "Usuario"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }

    @PATCH
    @Path("/upload/imagem/{id}")
    @RolesAllowed({ "Admin" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImagemForm form, @PathParam("id") Long id) throws IOException {
        String nomeImagem;
        nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
        PessoaResponseDTO pessoaDTO = service.findById(id);
        pessoaDTO = service.updateNomeImagem(pessoaDTO.id(), nomeImagem);

        return Response.ok(pessoaDTO).build();

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

}
