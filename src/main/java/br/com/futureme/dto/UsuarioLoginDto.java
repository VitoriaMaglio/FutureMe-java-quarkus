package br.com.futureme.dto;

import br.com.futureme.model.Usuario;

/**
 * DTO de login para a entidade Usuario.
 * Contém apenas login e senha, usado para autenticação.
 */
public class UsuarioLoginDto {

    private String loginUsua;
    private String senhaUsua;

    public UsuarioLoginDto() {}

    public UsuarioLoginDto(String login, String senha) {
        this.loginUsua = login;
        this.senhaUsua = senha;
    }

    public String getLoginUsua() {
        return loginUsua;
    }

    public void setLoginUsua(String loginUsua) {
        this.loginUsua = loginUsua;
    }

    public String getSenhaUsua() {
        return senhaUsua;
    }

    public void setSenhaUsua(String senhaUsua) {
        this.senhaUsua = senhaUsua;
    }

    /**
     * Converte este DTO em objeto Usuario.
     *
     * @param
     * @return Objeto Usuario correspondente
     */
    public Usuario convertToUsuario() {
        Usuario usuario = new Usuario();
        usuario.setLoginUsua(this.loginUsua);
        usuario.setSenhaUsua(this.senhaUsua);
        return usuario;
    }
}
