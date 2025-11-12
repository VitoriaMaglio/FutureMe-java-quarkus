package br.com.futureme.dao;

import br.com.futureme.model.Rotina;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class RotinaDao {
    @Inject
    DataSource dataSource;

    public void cadastrarRotina(Rotina rotina) throws SQLException{
        String buscarIdSql = "SELECT idUsua FROM USUARIO WHERE loginUsua = ?";
        String inserirRotinaSql = "INSERT INTO ROTINA (idUsua, horasSono, horasTrab, pausasDiarias) " +
                "VALUES (?, ?, ?, ?)";


        try (Connection conn = dataSource.getConnection()) {
            // 1️⃣ Buscar o idUsua com base no login
            int idUsua = -1;
            try (PreparedStatement psBuscar = conn.prepareStatement(buscarIdSql)) {
                psBuscar.setString(1, rotina.getUsuario().getLoginUsua());
                ResultSet rs = psBuscar.executeQuery();
                if (rs.next()) {
                    idUsua = rs.getInt("idUsua");
                } else {
                    throw new SQLException("Usuário não encontrado para o login: " + rotina.getUsuario().getLoginUsua());
                }
            }

            // 2️⃣ Inserir a rotina usando o idUsua encontrado
            try (PreparedStatement psInserir = conn.prepareStatement(inserirRotinaSql)) {
                psInserir.setInt(1, idUsua);
                psInserir.setInt(2, rotina.getHorasSono());
                psInserir.setInt(3, rotina.getHorasTrab());
                psInserir.setInt(4, rotina.getPausasDiarias());
                psInserir.executeUpdate();
            }
        }
    }

    public Rotina buscarRotina(String loginUsua) throws SQLException {
        String sql = """
                    SELECT r.idRotina, r.horasSono, r.horasTrab, r.pausasDiarias,
                           u.idUsua, u.loginUsua, u.nomeUsua
                    FROM ROTINA r
                    JOIN USUARIO u ON r.idUsua = u.idUsua
                    WHERE u.loginUsua = ?
                """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loginUsua);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsua(rs.getInt("idUsua"));
                usuario.setLoginUsua(rs.getString("loginUsua"));
                usuario.setNomeUsua(rs.getString("nomeUsua"));

                Rotina rotina = new Rotina();
                rotina.setIdRotina(rs.getInt("idRotina"));
                rotina.setHorasSono(rs.getInt("horasSono"));
                rotina.setHorasTrab(rs.getInt("horasTrab"));
                rotina.setPausasDiarias(rs.getInt("pausasDiarias"));
                rotina.setUsuario(usuario);

                return rotina;
            }
        }
        return null;
    }


    public void atualizarRotina(String loginUsua, int horasSono, int horasTrab, int pausas) throws SQLException {
        String sql = """
        UPDATE rotina
        SET horasSono = ?, horasTrab = ?, pausasDiarias = ?
        WHERE idUsua = (SELECT idUsua FROM usuario WHERE loginUsua = ?)
    """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, horasSono);
            ps.setInt(2, horasTrab);
            ps.setInt(3, pausas);
            ps.setString(4, loginUsua);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Rotina atualizada com sucesso para o usuário: " + loginUsua);
            } else {
                System.out.println("Nenhuma rotina encontrada para o login informado.");
            }
        }
    }


    public void deletarRotina(String loginUsua) throws SQLException {
        String sql = """
        DELETE FROM rotina
        WHERE idUsua = (SELECT idUsua FROM usuario WHERE loginUsua = ?)
    """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, loginUsua);
            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Rotina do usuário '" + loginUsua + "' removida com sucesso!");
            } else {
                System.out.println("Nenhuma rotina encontrada para o login informado.");
            }
        }
    }


}
