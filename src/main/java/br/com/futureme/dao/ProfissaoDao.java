package br.com.futureme.dao;

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


        public List<String> buscarProfissoesPorArea(String areaInteresse) throws SQLException {
            List<String> resultados = new ArrayList<>();

            String sql = """
        SELECT p.nome, p.descricao, r.descricao AS recomendacao
        FROM profissao p
        JOIN recomendacao r ON p.idProfi = r.idProfi
        WHERE LOWER(p.area) LIKE LOWER(?)
    """;

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, "%" + areaInteresse.trim() + "%"); // busca mais flexível
                System.out.println("🔍 Executando busca por área: " + areaInteresse);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String profissao = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    String recomendacao = rs.getString("recomendacao");

                    resultados.add(
                            "Profissão: " + profissao +
                                    "\nDescrição: " + descricao +
                                    "\nRecomendação: " + recomendacao + "\n"
                    );
                }
            }

            System.out.println("🟢 Resultado retornado: " + resultados.size() + " profissão(ões).");
            return resultados;
        }

}


