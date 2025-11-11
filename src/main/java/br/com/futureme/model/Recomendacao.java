package br.com.futureme.model;

public class Recomendacao {

    private int idRecomenda;
    private int idUsua;   // FK → Usuario
    private int idRotina; // FK → Rotina
    private int idProfi;  // FK → Profissao
    private String descricao;

}
