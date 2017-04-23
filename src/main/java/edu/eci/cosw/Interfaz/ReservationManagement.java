package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Reservations;

import java.util.List;

/**
 * Created by 2093715 on 3/28/17. Deivan OLiva
 */
public interface ReservationManagement {

    public List<Reservations> getReservations() throws Exception;
    public List<Reservations> getReservationByState(String state) throws Exception;

//    public List<Reserva> getReservasActivas(String iduser);
//    public List<Reserva> getReservasPendientes(String iduser);
//    public List<Reserva> getReservasAtendidas(String iduser);
//    public void addReserva(Reserva s);

}
