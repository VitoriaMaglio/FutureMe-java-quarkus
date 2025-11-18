package br.com.futureme.resource;

import br.com.futureme.dto.ProfissaoRecomendacaoDTO;
import br.com.futureme.model.Usuario;
import br.com.futureme.service.ProfissaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/profissao")
public class ProfissaoResource {

    @Inject
    ProfissaoService profissaoService;

    @POST
    public Response gerarRecomendacoes(Usuario usuario) {
            System.out.println(" JSON recebido: " + usuario);
            System.out.println(" Área recebida: " + usuario.getAreaInteresseUsua());
            try {
                List<ProfissaoRecomendacaoDTO> recomendacoes = profissaoService.gerarRecomendacoes(usuario);
            if (recomendacoes.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Nenhuma profissão encontrada para a área: " + usuario.getAreaInteresseUsua())
                        .build();
            }
            return Response.ok(recomendacoes).build();
        } catch (SQLException e) {
            return Response.serverError().entity("Erro ao gerar recomendação: " + e.getMessage()).build();
        }
    }
}
