package br.com.futureme.service;

import br.com.futureme.dao.UsuarioDao;
import br.com.futureme.dto.UsuarioRequestDTO;
import br.com.futureme.dto.UsuarioResponseDTO;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;

@ApplicationScoped
public class UsuarioService {
    @Inject
    UsuarioDao usuarioDao;

    public String autenticarUsuario(Usuario usuario) throws SQLException {
        boolean autenticado = usuarioDao.autenticarUsuario(usuario);
        if (autenticado) {
            return "Usuário logado com sucesso";
        } else {
            return "Usuário e/ou senha inválidos";
        }
    }

    public void cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) throws SQLException {
        if (usuarioRequestDTO.getNomeUsua() == null && usuarioRequestDTO.getProfissaoAntigaUsua() == null
                && usuarioRequestDTO.getAreaInteresseUsua() == null) {
            throw new IllegalArgumentException("Dados obrigatórios!");
        } else {
            usuarioDao.cadastrarUsuario(usuarioRequestDTO.convertToUsuario(usuarioRequestDTO));
        }
    }

    public UsuarioResponseDTO buscarLogin(String login) throws SQLException {
        Usuario usuario = usuarioDao.buscarLogin(login);
        if (usuario != null) {

            return new UsuarioResponseDTO().convertToUsuarioResponseDto(usuario);
        } else {

            throw new NullPointerException("Login inválido!");
        }
    }

    public UsuarioResponseDTO alterarUsuario(String login, UsuarioRequestDTO request) throws SQLException {

        Usuario usuario = usuarioDao.buscarLogin(login);
        if (usuario == null) {
            return null;
        }
        usuario.setProfissaoAntigaUsua(request.getProfissaoAntigaUsua());
        usuario.setAreaInteresseUsua(request.getAreaInteresseUsua());
        usuarioDao.atualizarUsuario( usuario.getLoginUsua(),
                request.getProfissaoAntigaUsua(),
                request.getAreaInteresseUsua() );
        return UsuarioResponseDTO.convertToUsuarioResponseDto(usuario);
    }

    public void excluirUsua(String login) throws SQLException {
        usuarioDao.excluirUsua(login);
    }

}

