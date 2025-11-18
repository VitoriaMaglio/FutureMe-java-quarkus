package br.com.futureme.dto;

import br.com.futureme.model.Recomendacao;

public class ProfissaoRecomendacaoDTO {
    private String nome;
    private String descricao;
    private Recomendacao recomendacao;

    public ProfissaoRecomendacaoDTO() {}

    public ProfissaoRecomendacaoDTO(String nome, String descricao, Recomendacao recomendacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.recomendacao = recomendacao;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Recomendacao getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(Recomendacao recomendacao) {
        this.recomendacao = recomendacao;
    }
}
