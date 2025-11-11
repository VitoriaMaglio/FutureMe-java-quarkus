package br.com.futureme.dto;

import br.com.futureme.model.Usuario;

/**
 * DTO de requisição para a entidade Usuario.
 * Contém dados que o cliente envia para criar ou atualizar um usuário.
 */
public class UsuarioRequestDTO {


    private String login;
    private String senha;
    private String nomeUsua;
    private String cpfUsua;
    private String emailUsua;
    private String telefoneUsua;
    private String profissaoAntigaUsua;
    private String areaInteresseUsua;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String areaInteresseUsua, String profissaoAntigaUsua, String telefoneUsua, String emailUsua, String cpfUsua, String nomeUsua, String senha, String login) {
        this.areaInteresseUsua = areaInteresseUsua;
        this.profissaoAntigaUsua = profissaoAntigaUsua;
        this.telefoneUsua = telefoneUsua;
        this.emailUsua = emailUsua;
        this.cpfUsua = cpfUsua;
        this.nomeUsua = nomeUsua;
        this.senha = senha;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsua() {
        return nomeUsua;
    }

    public void setNomeUsua(String nomeUsua) {
        this.nomeUsua = nomeUsua;
    }

    public String getCpfUsua() {
        return cpfUsua;
    }

    public void setCpfUsua(String cpfUsua) {
        this.cpfUsua = cpfUsua;
    }

    public String getEmailUsua() {
        return emailUsua;
    }

    public void setEmailUsua(String emailUsua) {
        this.emailUsua = emailUsua;
    }

    public String getTelefoneUsua() {
        return telefoneUsua;
    }

    public void setTelefoneUsua(String telefoneUsua) {
        this.telefoneUsua = telefoneUsua;
    }

    public String getProfissaoAntigaUsua() {
        return profissaoAntigaUsua;
    }

    public void setProfissaoAntigaUsua(String profissaoAntigaUsua) {
        this.profissaoAntigaUsua = profissaoAntigaUsua;
    }

    public String getAreaInteresseUsua() {
        return areaInteresseUsua;
    }

    public void setAreaInteresseUsua(String areaInteresseUsua) {
        this.areaInteresseUsua = areaInteresseUsua;
    }

    /**
     * Converte um objeto Usuario em UsuarioRequestDTO.
     *
     * @param usuario Entidade Usuario
     * @return DTO correspondente
     */
    public UsuarioRequestDTO convertToUsuarioRequestDTO(Usuario usuario){
        return new UsuarioRequestDTO(usuario.getLoginUsua(), usuario.getSenhaUsua(), usuario.getNomeUsua(),usuario.getCpfUsua(), usuario.getEmailUsua(), usuario.getTelefoneUsua(), usuario.getProfissaoAntigaUsua(), usuario.getAreaInteresseUsua() );
    }

    /**
     * Converte este DTO em objeto Usuario.
     *
     * @param dto DTO de usuário
     * @return Objeto Usuario correspondente
     */
    public Usuario convertToUsuario(UsuarioRequestDTO dto){
        return new Usuario( dto.login, dto.senha, dto.nomeUsua,dto.cpfUsua, dto.emailUsua,dto.telefoneUsua,dto.profissaoAntigaUsua,dto.areaInteresseUsua);
    }

}

