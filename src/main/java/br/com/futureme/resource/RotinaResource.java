package br.com.futureme.resource;
import br.com.futureme.dto.RotinaRequestDTO;
import br.com.futureme.dto.RotinaResponseDTO;
import br.com.futureme.service.RotinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/rotina")
public class RotinaResource {

    @Inject
    RotinaService rotinaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarRotina(RotinaRequestDTO request) {
        try {
            rotinaService.cadastrarRotina(request);
            RotinaResponseDTO cadastrado = rotinaService.buscarRotina(request.getUsuario().getLoginUsua());
            return Response.status(Response.Status.CREATED).entity(cadastrado).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao cadastrar rotina: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{loginUsua}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarRotina(@PathParam("loginUsua") String login) {
        try {
            RotinaResponseDTO rotina = rotinaService.buscarRotina(login);
            if (rotina != null) {
                return Response.ok(rotina).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"erro\": \"Rotina não encontrada\"}")
                        .build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"erro\": \"Erro ao buscar rotina: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @PUT
    @Path("/{loginUsua}")
    public Response alterarRotina(@PathParam("loginUsua") String login, RotinaRequestDTO request) {
        try {
            RotinaResponseDTO atualizado = rotinaService.atualizarRotina(login, request);
            return Response.ok(atualizado).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar rotina: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{loginUsua}")
    public Response excluirRotina(@PathParam("loginUsua") String login) {
        try {
            rotinaService.deletarRotina(login);
            return Response.ok().entity("Rotina excluída com sucesso!").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao excluir rotina: " + e.getMessage()).build();
        }
    }



}
