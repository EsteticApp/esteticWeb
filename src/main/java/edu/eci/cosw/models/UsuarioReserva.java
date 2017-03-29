package edu.eci.cosw.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deivan Oliva on 28/03/2017.
 */
public class UsuarioReserva {

    private Usuario usuario;
    private List<Reserva> reservas ;

    public UsuarioReserva(Usuario usuario) {
        this.usuario = usuario;
        this.reservas = new ArrayList<Reserva>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
}
