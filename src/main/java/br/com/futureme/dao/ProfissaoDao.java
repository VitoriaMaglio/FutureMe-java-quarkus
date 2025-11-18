package br.com.futureme.dao;

import br.com.futureme.dto.ProfissaoRecomendacaoDTO;
import br.com.futureme.model.Recomendacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProfissaoDao {
    @Inject
    DataSource dataSource;

        public List<ProfissaoRecomendacaoDTO> buscarProfissoesPorArea(String areaInteresse) throws SQLException {
            List<ProfissaoRecomendacaoDTO> resultados = new ArrayList<>();

            String sql = """
                SELECT 
                    p.nome, 
                    p.descricao, 
                    r.descricao AS recomendacao
                    FROM profissao p
                    JOIN recomendacao r ON p.idProfi = r.idProfi
                       WHERE LOWER(p.area) LIKE LOWER(?)
            """;

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, "%" + areaInteresse.trim() + "%");

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    String recomendacaoTexto = rs.getString("recomendacao");
                    Recomendacao recomendacao = new Recomendacao(recomendacaoTexto);
                    resultados.add(new ProfissaoRecomendacaoDTO(nome, descricao, recomendacao));
                }
            }
            return resultados;

        }
}


