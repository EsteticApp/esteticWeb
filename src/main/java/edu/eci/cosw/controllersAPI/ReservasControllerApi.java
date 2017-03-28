package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ReservasOPeraciones;
import edu.eci.cosw.models.Reserva;
import edu.eci.cosw.models.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 2093715 on 3/28/17. Deivan OLiva
 */


@RestController
@RequestMapping("/reservas")
public class ReservasControllerApi {

    @Autowired
    ReservasOPeraciones reservasOPeraciones;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reserva> getReservas() {
        System.out.println("Almenos llegue");
        return reservasOPeraciones.getReservas(1);
        //return null;
    }

}
