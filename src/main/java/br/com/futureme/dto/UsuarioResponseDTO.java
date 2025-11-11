package br.com.futureme.dto;

import br.com.futureme.model.Usuario;

/**
 * DTO de resposta para a entidade Usuario.
 * Contém apenas dados que serão expostos ao cliente.
 */
public class UsuarioResponseDTO {

    private String loginUsua;
    private String nomeUsua;
    private String emailUsua;
    private String profissaoAntigaUsua;
    private String areaInteresseUsua;


    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String login, String nomeUsua, String emailUsua, String profissaoAntigaUsua, String areaInteresseUsua) {
        this.loginUsua = login;
        this.nomeUsua = nomeUsua;
        this.emailUsua = emailUsua;
        this.profissaoAntigaUsua = profissaoAntigaUsua;
        this.areaInteresseUsua = areaInteresseUsua;
    }

    public String getLogin() {
        return loginUsua;
    }
    public void setLogin(String login) {
        this.loginUsua = login;
    }

    public String getNomeUsua() {
        return nomeUsua;
    }

    public void setNomeUsua(String nomeUsua) {
        this.nomeUsua = nomeUsua;
    }

    public String getEmailUsua() {
        return emailUsua;
    }

    public void setEmailUsua(String emailUsua) {
        this.emailUsua = emailUsua;
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
     * Converte um objeto Usuario em UsuarioResponseDTO.
     *
     * @param usuario Entidade Usuario
     * @return DTO correspondente
     */
    public UsuarioResponseDTO convertToUsuarioResponseDto(Usuario usuario){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setLogin(usuario.getLoginUsua());
        dto.setNomeUsua(usuario.getNomeUsua());
        dto.setEmailUsua(usuario.getEmailUsua());
        dto.setProfissaoAntigaUsua(usuario.getProfissaoAntigaUsua());
        dto.setAreaInteresseUsua(usuario.getAreaInteresseUsua());
        return dto;
    }

    /**
     * Converte este DTO em objeto Usuario.
     *
     * @param dto DTO de usuário
     * @return Objeto Usuario correspondente
     */
    public Usuario convertToUsuario(UsuarioResponseDTO dto){
        return new Usuario(dto.loginUsua, dto.nomeUsua, dto.emailUsua, dto.profissaoAntigaUsua, dto.areaInteresseUsua);
    }
}
