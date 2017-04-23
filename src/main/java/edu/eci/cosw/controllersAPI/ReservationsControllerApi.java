package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ReservationManagement;
import edu.eci.cosw.models.*;
import org.apache.log4j.Logger;
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
public class ReservationsControllerApi {

    @Autowired
    ReservationManagement reservationManagement;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsManagement(){
        try {
            List<Reservations> data = reservationManagement.getReservations();
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsByStateManagement(@PathVariable String state){
        try{
            List<Reservations> data = reservationManagement.getReservationByState(state);
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations with that state found", HttpStatus.NOT_FOUND);
        }
    }

    //Obtiene las reservas de un cliente dado.
    @RequestMapping(path = "/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsForClientManagement(@PathVariable String id){
        try{
            List<Reservations> data = reservationManagement.getReservationByState(id);
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations with that state found", HttpStatus.NOT_FOUND);
        }
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Reserva> getReservas() {
//        System.out.println("Almenos llegue");
//        return reservationManagement.getReservasActivas("1");
//        //return null;
//    }

//    @RequestMapping(path = "/email", method = RequestMethod.POST)
//    public ResponseEntity<?> getReservasUsers(@RequestBody EmailString email){
//        try {
//            System.out.println("Lllegua a consulta reserva "+email.getEmail());
//            List<Reserva> reservas = reservationManagement.getReservasActivas(email.getEmail());
//            EmailReservas data = new EmailReservas();
//            data.setReservas(reservas);
//            System.out.println(data);
//            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
//        }
//    }


}
