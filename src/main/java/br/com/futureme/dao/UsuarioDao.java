package br.com.futureme.dao;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class UsuarioDao {
    @Inject
    DataSource dataSource;//objeto de conexão com o banco de dados, garante uma única instância

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario " +
                "(loginUsua, senhaUsua, nomeUsua, cpfUsua, emailUsua, telefoneUsua, profissaoAntigaUsua, areaInteresseUsua) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getLoginUsua());
            ps.setString(2, usuario.getSenhaUsua());
            ps.setString(3, usuario.getNomeUsua());
            ps.setString(4, usuario.getCpfUsua());
            ps.setString(5, usuario.getEmailUsua());
            ps.setString(6, usuario.getTelefoneUsua());
            ps.setString(7, usuario.getProfissaoAntigaUsua());
            ps.setString(8, usuario.getAreaInteresseUsua());

            ps.executeUpdate();
        }
    }

    public Usuario buscarLogin(String login) throws SQLException{
        String sql = "SELECT * FROM USUARIO WHERE LOGINUSUA = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLoginUsua(rs.getString("loginUsua"));
                usuario.setNomeUsua(rs.getString("nomeUsua"));
                usuario.setProfissaoAntigaUsua(rs.getString("profissaoAntigaUsua"));
                usuario.setAreaInteresseUsua(rs.getString("areaInteresseUsua"));
                return usuario;
            }
        }
        return null;
    }

    public void atualizarUsuario(int idUsua, String profissao, String areaInteresse)throws SQLException {
        String sql = "UPDATE usuario SET profissaoAntigaUsua = ?, areaInteresseUsua = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profissao);
            ps.setString(2,areaInteresse);
            ps.setInt(3, idUsua);
            ps.executeUpdate();

        }
    }

    public void excluirUsua(String login)throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE LOGINUSUA=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário com login '" + login + "' removido com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse login.");
            }
        }
    }


}




