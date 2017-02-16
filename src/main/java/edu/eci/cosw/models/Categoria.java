package edu.eci.cosw.models;


import java.util.List;

/**
 * Creacion de categoria
 * @author  Deivan OLiva
 */

public class Categoria {

    private String nombre;
    private List<Servicio> servicios;

    /**
     * Constructor de una categoria
     * @param nombre de la categoria
     */
    public Categoria(String nombre){

        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Actualizacion de nombre de la categoria
     * @param nombre
     */
    public void actualizaCategoria(String nombre){
        this.nombre = nombre;
    }

    /**
     * Retorna los servicios de una categoria
     * @return lista con servicios de una categoria
     */
    public List<Servicio> getServicios(){
        return servicios;
    }

    /**
     * Agrega un servicio si este no existe
     * @param servicio
     * @return true si el nuevo servicio no existe
     */
    public boolean addServicio(Servicio servicio){
        boolean estado = true;
        for(Servicio serv : servicios){
            if(serv.getNombre().equals(servicio.getNombre())){
                estado=false;
            }
        }
        if (estado){servicios.add(servicio);}
        return estado;
    }


}
