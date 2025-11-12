package br.com.futureme.dto;

import br.com.futureme.model.Rotina;
import br.com.futureme.model.Usuario;

public class RecomendacaoResponseDTO {

    private Usuario usuario;
    private Rotina rotina;


    public RecomendacaoResponseDTO(Usuario usuario, Rotina rotina) {
        this.usuario = usuario;
        this.rotina = rotina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
    }
    private String profissaoFutura;
    private String area;
    private String descricao;
    private int horasTrabalhoUsuario;

    public RecomendacaoResponseDTO(String profissaoFutura, String area, String descricao, int horasTrabalhoUsuario) {
        this.profissaoFutura = profissaoFutura;
        this.area = area;
        this.descricao = descricao;
        this.horasTrabalhoUsuario = horasTrabalhoUsuario;
    }
}
