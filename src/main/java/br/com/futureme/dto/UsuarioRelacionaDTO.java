package br.com.futureme.dto;

public class UsuarioRelacionaDTO {
    private String loginUsua;
    private String senhaUsua;

    public UsuarioRelacionaDTO() {
    }

    public UsuarioRelacionaDTO(String loginUsua) {
        this.loginUsua = loginUsua;
    }

    public UsuarioRelacionaDTO(String loginUsua, String senhaUsua) {
        this.loginUsua = loginUsua;
        this.senhaUsua = senhaUsua;
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
}
