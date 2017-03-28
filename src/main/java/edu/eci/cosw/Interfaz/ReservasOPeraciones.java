package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Reserva;
import edu.eci.cosw.models.Servicio;

import java.util.List;

/**
 * Created by 2093715 on 3/28/17. Deivan OLiva
 */
public interface ReservasOPeraciones {
    public List<Reserva> getReservas(Integer iduser);
    public void addReserva(Reserva s);

}
