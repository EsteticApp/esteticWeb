package edu.eci.cosw.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by estudiante on 2/16/17.
 */
public class Reserva {

    private int telefono;
    private String direccion;
    private Servicio servicios;

    public Reserva(int telefono, String direccion){

        this.telefono = telefono;
        this.direccion = direccion;
    }

    public List<String> getServiciosSolicitados(){
        List<String> listado = new ArrayList<>();

        listado.add(servicios.getNombre());
        return listado;


    }



}
