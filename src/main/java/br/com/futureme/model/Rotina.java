package br.com.futureme.model;

public class Rotina {

    private int idRotina;
    private Usuario usuario;
    private int horasSono;
    private int horasTrab;
    private int pausasDiarias;

    public Rotina() {
    }

    public Rotina(int idRotina, Usuario usuario, int horasSono, int horasTrab, int pausasDiarias) {
        this.idRotina = idRotina;
        this.usuario = usuario;
        this.horasSono = horasSono;
        this.horasTrab = horasTrab;
        this.pausasDiarias = pausasDiarias;
    }

    public int getIdRotina() {
        return idRotina;
    }

    public void setIdRotina(int idRotina) {
        this.idRotina = idRotina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getHorasSono() {
        return horasSono;
    }

    public void setHorasSono(int horasSono) {
        this.horasSono = horasSono;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }

    public int getPausasDiarias() {
        return pausasDiarias;
    }

    public void setPausasDiarias(int pausasDiarias) {
        this.pausasDiarias = pausasDiarias;
    }
}
