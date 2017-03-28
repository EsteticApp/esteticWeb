package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ReservasOPeraciones;
import edu.eci.cosw.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

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

    @RequestMapping(path = "/email", method = RequestMethod.POST)
    public ResponseEntity<?> getReservasUsers(@RequestBody EmailString email){
        try {
            System.out.println("Lllegua a consulta reserva "+email.getEmail());
            List<Reserva> reservas = reservasOPeraciones.getReservas(1);
            EmailReservas data = new EmailReservas();
            data.setReservas(reservas);
            System.out.println(data);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }


}
