package br.com.futureme.service;

import br.com.futureme.dao.UsuarioDao;
import br.com.futureme.dto.UsuarioRequestDTO;
import br.com.futureme.dto.UsuarioResponseDTO;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;

@ApplicationScoped //indica que o objeto anotado terá um único clico de vida durante toda a execução, criando uma única instância ->CDI Contexts and Dependency Injection
public class UsuarioService {
    @Inject
    UsuarioDao usuarioDao;

    //Métodos de validação
    //Validar cadastro de usuario-> chama o método e cadastra no banco convertendo o dtorequest para entidade bruta

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
            // converte o objeto Usuario retornado do DAO em DTO
            return new UsuarioResponseDTO().convertToUsuarioResponseDto(usuario);
        } else {
            // se o login não for encontrado
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
        usuarioDao.atualizarUsuario( usuario.getLoginUsua(),                      // id do usuário
                request.getProfissaoAntigaUsua(),         // nova profissão
                request.getAreaInteresseUsua() );
        return UsuarioResponseDTO.convertToUsuarioResponseDto(usuario);
    }

    public void excluirUsua(String login) throws SQLException {
        usuarioDao.excluirUsua(login);
    }
    //Métodos que seram chamados nos resources para serem validados e entrar no banco



}

