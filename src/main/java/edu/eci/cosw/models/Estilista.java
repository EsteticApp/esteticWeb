package edu.eci.cosw.models;

import java.util.List;

/**
 * Created by estudiante on 2/16/17.
 */
public class Estilista{

    private String nombre;
    private int cedula;
    //private String contraseña;
    //private String correo;
    private List<String> serviciosEstilista;

    public Estilista(String nombre, int cedula, List<String> serviciosEstilista){

        this.nombre = nombre;
        this.cedula = cedula;
        this.serviciosEstilista = serviciosEstilista;
    }

    public String getNombre(){

        return nombre;
    }

    public void setNombre(String nombre){

        this.nombre = nombre;
    }

    public int getCedula(){

        return cedula;
    }

    public void setCedula(int cedula){

        this.nombre = nombre;
    }

    public List<String> getServicios(){

        return serviciosEstilista;
    }



}
