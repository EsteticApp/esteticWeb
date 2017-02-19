package edu.eci.cosw.models;

/**
 * Creacion de servicios disponibles
 * @author Deivan OLiva
 */
public class Servicio {

    private String nombre;

    public Servicio(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }


}
