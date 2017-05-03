package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ReservationManagement;
import edu.eci.cosw.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/reserva/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsByStateManagement(@PathVariable String state){
        try{
            List<Reservations> data = reservationManagement.getReservationsByState(state);
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }catch (Exception ex){
//            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations with that state found", HttpStatus.NOT_FOUND);
        }
    }

    //Obtiene las reservas de un cliente dado.
    @RequestMapping(path = "/reserva/cliente/{clientID}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsByClientManagement(@PathVariable int clientID){
        try{
            System.out.println("==========================================");
            System.out.println("Acceso a la API");
            System.out.println("CLIENTE: " + clientID);
            List<Reservations> data = reservationManagement.getReservationsByClient(clientID);
            System.out.println("EMPTY: " + data.isEmpty());
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }catch (Exception ex){
//            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No reservations with that state found", HttpStatus.NOT_FOUND);
        }
    }

    // Obtiene las reservas asociadas a un profesional
    @RequestMapping(path = "/reserva/professional/{professionalID}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationsByProfessionalManagement(@PathVariable int professionalID){
        try{
            System.out.println("==========================================");
            System.out.println("Acceso a la API");
            System.out.println("PROFESSIONAL: " + professionalID);
            List<Reservations> data = reservationManagement.getReservationsByProfessional(professionalID);
            System.out.println("EMPTY: " + data.isEmpty());
            // IMPORTANTE
            // Se debe ajustar lo que se necesita.
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }catch (Exception ex){
//            Logger.getLogger(ReservationsControllerApi.class.getName()).log(null, ex);
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
