package br.com.futureme.dto;

import br.com.futureme.model.Rotina;
import br.com.futureme.model.Usuario;

public class RotinaRequestDTO {

    private UsuarioRelacionaDTO usuario;
    private int horasSono;
    private int horasTrab;
    private int pausasDiarias;

    public RotinaRequestDTO() {}

    public RotinaRequestDTO(UsuarioRelacionaDTO usuario, int horasSono, int horasTrab, int pausasDiarias) {
        this.usuario = usuario;
        this.horasSono = horasSono;
        this.horasTrab = horasTrab;
        this.pausasDiarias = pausasDiarias;
    }

    public UsuarioRelacionaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioRelacionaDTO usuario) {
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

    public static RotinaRequestDTO convertToRotinaRequestDTO(Rotina rotina) {
        UsuarioRelacionaDTO usuarioDto = new UsuarioRelacionaDTO(
                rotina.getUsuario().getLoginUsua(),
                rotina.getUsuario().getSenhaUsua()
        );

        return new RotinaRequestDTO(
                usuarioDto,
                rotina.getHorasSono(),
                rotina.getHorasTrab(),
                rotina.getPausasDiarias()
        );
    }

    public Rotina convertToRotina(Usuario usuario) {
        Rotina rotina = new Rotina();
        rotina.setUsuario(usuario);
        rotina.setHorasSono(this.horasSono);
        rotina.setHorasTrab(this.horasTrab);
        rotina.setPausasDiarias(this.pausasDiarias);
        usuario.setLoginUsua(getUsuario().getLoginUsua());
        rotina.setUsuario(usuario);
        return rotina;
    }
}
