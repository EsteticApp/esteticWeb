package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ReservationManagement;
import edu.eci.cosw.Interfaz.repositorio.ReservationRepository;
import edu.eci.cosw.models.Reserva;
import edu.eci.cosw.models.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2094687 on 4/20/17.
 */
@Service
public class ReservationsServiceImpl implements ReservationManagement{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservations> getReservations() throws Exception{
        List<Reservations> reservations = reservationRepository.findAll();
        if(reservations.isEmpty())throw new Exception();
        return reservations;
    }

    @Override
    public List<Reservations> getReservationByState(String state) throws Exception {
        List<Reservations> reservations = reservationRepository.getReservationByState(state);
        if(reservations.isEmpty())throw new Exception();
        return reservations;
    }

    @Override
    public List<Reserva> getReservasActivas(String iduser) {
        return null;
    }

    @Override
    public List<Reserva> getReservasPendientes(String iduser) {
        return null;
    }

    @Override
    public List<Reserva> getReservasAtendidas(String iduser) {
        return null;
    }

    @Override
    public void addReserva(Reserva s) {

    }
}
