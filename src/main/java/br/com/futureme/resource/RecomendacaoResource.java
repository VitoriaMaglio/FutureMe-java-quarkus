package br.com.futureme.resource;

import br.com.futureme.service.RecomendacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/recomendacao")
public class RecomendacaoResource {

    @Inject
    RecomendacaoService recomendacaoService;

    @GET
    @Path("/{idProfi}")
    public Response getRecomendacao(@PathParam("nome") String nome) {
        try {
            String recomendacao = recomendacaoService.buscarRecomendacaoPorProfissao(nome);
            if (recomendacao == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Nenhuma recomendação encontrada para essa profissão.")
                        .build();
            }
            return Response.ok(recomendacao).build();
        } catch (SQLException e) {
            return Response.serverError().entity("Erro ao buscar recomendação: " + e.getMessage()).build();
        }
    }



}
