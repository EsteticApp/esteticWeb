package edu.eci.cosw.models;

/**
 * Creacion de servicios disponibles
 * @author Deivan OLiva
 */
public class Servicio {

    private String nombre;
    private Categoria categoria;

    public Servicio(){

    }

    public Servicio(String nombre, Categoria categoria){

        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Categoria getCategoria() {

        return categoria;
    }

    public void setCategoria(Categoria c) {

        this.categoria = c;
    }




}
