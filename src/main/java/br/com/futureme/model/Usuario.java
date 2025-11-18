package br.com.futureme.model;

public class Usuario {
    //atributtes
    private int idUsua;
    private String loginUsua;
    private String senhaUsua;
    private String nomeUsua;
    private String cpfUsua;
    private String emailUsua;
    private String telefoneUsua;
    private String profissaoAntigaUsua;
    private String areaInteresseUsua;

    //Construtor
    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.loginUsua = login;
        this.senhaUsua = senha;

    }

    public Usuario(int id, String login, String senha, String nomeUsua, String cpfUsua, String emailUsua, String telefoneUsua, String profissaoAntigaUsua, String areaInteresseUsua) {
        this.idUsua = id;
        this.loginUsua = login;
        this.senhaUsua = senha;
        this.nomeUsua = nomeUsua;
        this.cpfUsua = cpfUsua;
        this.emailUsua = emailUsua;
        this.telefoneUsua = telefoneUsua;
        this.profissaoAntigaUsua = profissaoAntigaUsua;
        this.areaInteresseUsua = areaInteresseUsua;
    }
    public Usuario(String login, String senha, String nomeUsua, String cpfUsua, String emailUsua, String telefoneUsua, String profissaoAntigaUsua, String areaInteresseUsua) {
        this.loginUsua = login;
        this.senhaUsua = senha;
        this.nomeUsua = nomeUsua;
        this.cpfUsua = cpfUsua;
        this.emailUsua = emailUsua;
        this.telefoneUsua = telefoneUsua;
        this.profissaoAntigaUsua = profissaoAntigaUsua;
        this.areaInteresseUsua = areaInteresseUsua;
    }

    public Usuario(String loginUsua, String nome, String email, String profissaoAntiga, String areaInteresse) {
        this.loginUsua = loginUsua;
        this.emailUsua = email;
        this.profissaoAntigaUsua = profissaoAntiga;
        this.areaInteresseUsua = areaInteresse;
    }

    //getters e setters

    public int getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(int idUsua) {
        this.idUsua = idUsua;
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

}