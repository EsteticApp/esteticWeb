package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ReservasOPeraciones;
import edu.eci.cosw.models.Reserva;
import edu.eci.cosw.models.Usuario;
import edu.eci.cosw.models.UsuarioReserva;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 2093715 on 3/28/17.
 */
@Service
public class ReservasStub implements ReservasOPeraciones{

    private static List<Reserva> reservas;
    private List<UsuarioReserva> usuarios;
    private User user;

    public ReservasStub() {
        user = new User();
        Usuario us = user.getUserByEmail("cliente@mail.com");
        System.out.println("usuario prueba:"+us);
        reservas = new ArrayList<>();
        reservas.add(new Reserva(1,1,new Date(),null,321456841,"Calle 12 - n 23 34 casa 2",null,"Desconectado",20000.0));
        reservas.add(new Reserva(2,1,new Date(),null,325458798,"Avenida 5 34 56 3 Piso",null,"Desconectado",212000.0));
        reservas.add(new Reserva(3,1,new Date(),null,300252525,"Calle 1 n 34 56 y ",null,"Desconectado",65000.0));
        UsuarioReserva ur = new UsuarioReserva(us);
        ur.setReservas(reservas);
        usuarios = new ArrayList<>();
        usuarios.add(ur);
    }

    @Override
    public List<Reserva> getReservasActivas(String iduser) {
        for (UsuarioReserva ur : usuarios){
            if(ur.getUsuario().getEmail().equals(iduser)){
                reservas=ur.getReservas();}
        }
        return reservas;
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
