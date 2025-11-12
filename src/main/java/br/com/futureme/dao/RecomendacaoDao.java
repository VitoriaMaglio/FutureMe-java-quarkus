package br.com.futureme.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@ApplicationScoped
public class RecomendacaoDao {
    @Inject
    DataSource dataSource;

    public String buscarRecomendacaoPorIdProfissao(String nome) throws SQLException {
        String sql = "SELECT descricao FROM recomendacao WHERE nome = ?";
        String recomendacao = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                recomendacao = rs.getString("descricao");
            }
        }

        return recomendacao;
    }

}
