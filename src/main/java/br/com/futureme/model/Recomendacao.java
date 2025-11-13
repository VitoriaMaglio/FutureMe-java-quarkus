package br.com.futureme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Recomendacao {

    @JsonIgnore
    private int idRecomenda;
    @JsonIgnore
    private int idProfi;
    private String descricao;

    public Recomendacao() {
    }

    public Recomendacao(String descricao) {
        this.descricao = descricao;
    }

    public Recomendacao(int idRecomenda, int idProfi, String descricao) {
        this.idRecomenda = idRecomenda;
        this.idProfi = idProfi;
        this.descricao = descricao;
    }

    public int getIdRecomenda() {
        return idRecomenda;
    }

    public void setIdRecomenda(int idRecomenda) {
        this.idRecomenda = idRecomenda;
    }

    public int getIdProfi() {
        return idProfi;
    }

    public void setIdProfi(int idProfi) {
        this.idProfi = idProfi;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
