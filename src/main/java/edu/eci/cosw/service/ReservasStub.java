package edu.eci.cosw.service;



import edu.eci.cosw.Interfaz.ReservationManagement;
import edu.eci.cosw.models.Reservations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2093715 on 3/28/17.
 */
public class ReservasStub implements ReservationManagement {

    @Override
    public List<Reservations> getReservations() throws Exception{
        List<Reservations> reservationsList = new ArrayList<>();
        if(reservationsList.isEmpty()) throw new Exception();
        return reservationsList;
    }

    @Override
    public List<Reservations> getReservationsByState(String state) throws Exception {
        List<Reservations> reservationsList = new ArrayList<>();
        if(reservationsList.isEmpty()) throw new Exception();
        return reservationsList;
    }

    @Override
    public List<Reservations> getReservationsByClient(int clientID) throws Exception {
        return null;
    }

    @Override
    public List<Reservations> getReservationsByProfessional(int professionalID) throws Exception {
        return null;
    }

    //    private static List<Reserva> reservas;
//    private List<UsuarioReserva> usuarios;
//    private edu.eci.cosw.service.User user;
//
//    public ReservasStub() {
//        //Para cliente
//        user = new edu.eci.cosw.service.User();
//        edu.eci.cosw.Interfaz.User us = user.getUserByEmail("cliente@mail.com");
//        System.out.println("usuario prueba:"+us);
//        reservas = new ArrayList<>();
//        reservas.add(new Reserva(1,1,new Date(),null,321456841,"Calle 12 - n 23 34 casa 2",null,"Desconectado",20000.0));
//        reservas.add(new Reserva(2,1,new Date(),null,325458798,"Avenida 5 34 56 3 Piso",null,"Desconectado",212000.0));
//        reservas.add(new Reserva(3,1,new Date(),null,300252525,"Calle 1 n 34 56 y ",null,"Desconectado",65000.0));
//        UsuarioReserva ur = new UsuarioReserva(us);
//        ur.setReservas(reservas);
//        usuarios = new ArrayList<>();
//        usuarios.add(ur);
//
//        //para profesional
//        us = user.getUserByEmail("profesional@mail.com");
//        System.out.println("usuario prueba:"+us);
//        reservas = new ArrayList<>();
//        reservas.add(new Reserva(1,2,new Date(),null,86202011,"Avenida 112 - n 123 34 casa 2",null,"Desconectado",200000.0));
//        reservas.add(new Reserva(2,2,new Date(),null,35026541,"Trans 5 34 56 3 Piso",null,"Desconectado",112000.0));
//        reservas.add(new Reserva(3,3,new Date(),null,31854745,"Calle 1 n 34 56 y ",null,"Desconectado",65000.0));
//        ur = new UsuarioReserva(us);
//        ur.setReservas(reservas);
//        usuarios.add(ur);
//    }
//
//    @Override
//    public List<Reserva> getReservasActivas(String iduser) {
//        List<Reserva> r = new ArrayList<>();
//        for (UsuarioReserva ur : usuarios){
//            if(ur.getUser().getEmail().equals(iduser)){
//                r=ur.getReservas();}
//        }
//        return r;
//    }
//
//    @Override
//    public List<Reserva> getReservasPendientes(String iduser) {
//        return null;
//    }
//
//    @Override
//    public List<Reserva> getReservasAtendidas(String iduser) {
//        return null;
//    }
//
//    @Override
//    public void addReserva(Reserva s) {
//
//    }
}
