package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ReservasOPeraciones;
import edu.eci.cosw.models.Reserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2093715 on 3/28/17.
 */
@Service
public class ReservasStub implements ReservasOPeraciones{

    private static List<Reserva> reservas;

    public ReservasStub() {
        reservas = new ArrayList<>();
        reservas.add(new Reserva(1,1,null,null,123123123,"Calle 123",null,"Desconectado",20.000));
        reservas.add(new Reserva(2,2,null,null,123123123,"Calle 123",null,"Desconectado",20.000));
        reservas.add(new Reserva(3,3,null,null,123123123,"Calle 123",null,"Desconectado",20.000));
    }

    @Override
    public List<Reserva> getReservas(Integer iduser) {
        return reservas;
    }

    @Override
    public void addReserva(Reserva s) {

    }
}
