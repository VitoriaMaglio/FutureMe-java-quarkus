package br.com.futureme.resource;

import br.com.futureme.dto.UsuarioRequestDTO;
import br.com.futureme.dto.UsuarioResponseDTO;
import br.com.futureme.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuario")

public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(UsuarioRequestDTO request) {
        try {
            usuarioService.cadastrarUsuario(request);
            UsuarioResponseDTO cadastrado = usuarioService.buscarLogin(request.getLoginUsua());
            if (cadastrado.getLogin().equals(request.getLoginUsua())) {
                return Response.status(Response.Status.CREATED).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao cadastrar usuário: " + e.getMessage()) // <<< também envia pro Postman
                    .build();
        }
    }


    @GET
    @Path("/{loginUsua}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarUsuarioPorLogin(@PathParam("loginUsua") String login) {
        try {
            UsuarioResponseDTO usuario = usuarioService.buscarLogin(login);
            if (usuario != null) {
                return Response.ok(usuario).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"erro\": \"Usuário não encontrado\"}")
                        .build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"erro\": \"Erro ao buscar usuário: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @PUT
    @Path("/{loginUsua}")
    public Response alterarUsuario(@PathParam("loginUsua") String login, UsuarioRequestDTO request) {
        try {
            UsuarioResponseDTO atualizado = usuarioService.alterarUsuario(login, request);
            return Response.ok(atualizado).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar usuário: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{loginUsua}")
    public Response excluirUsua(@PathParam("loginUsua") String login) {
        try {
            usuarioService.excluirUsua(login);
            return Response.ok().entity("Usuário excluído com sucesso!").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao excluir usuário: " + e.getMessage()).build();
        }
    }


}
