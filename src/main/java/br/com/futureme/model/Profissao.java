package br.com.futureme.model;

public class Profissao {
    private int idProfi;
    private String nome;
    private String area;
    private String descricao;
    private String competencias;
    private String nivelDemanda;

    public Profissao() {
    }

    public Profissao(int idProfi, String nome, String area, String descricao, String competencias, String nivelDemanda) {
        this.idProfi = idProfi;
        this.nome = nome;
        this.area = area;
        this.descricao = descricao;
        this.competencias = competencias;
        this.nivelDemanda = nivelDemanda;
    }

    public int getIdProfi() {
        return idProfi;
    }

    public void setIdProfi(int idProfi) {
        this.idProfi = idProfi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getNivelDemanda() {
        return nivelDemanda;
    }

    public void setNivelDemanda(String nivelDemanda) {
        this.nivelDemanda = nivelDemanda;
    }



}
