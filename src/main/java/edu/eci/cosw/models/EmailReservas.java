package edu.eci.cosw.models;

import java.util.List;

/**
 * Created by estudiante on 3/28/17.
 */
public class EmailReservas {
    private List<Reserva> reservas;

    public EmailReservas() {

    }
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
