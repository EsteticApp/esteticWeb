package edu.eci.cosw.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Creacion de categoria
 * @author  Deivan OLiva
 */

public class Categoria {

    private String name;
    private List<Servicio> services = new ArrayList<>();

    /**
     * Constructor de una categoria
     * @param name de la categoria
     */
    public Categoria(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Retorna los servicios de una categoria
     * @return lista con servicios de una categoria
     */
    public List<Servicio> getServices(){
        return services;
    }

    /**
     * Agrega un servicio si este no existe
     * @param service
     * @return true si el nuevo servicio no existe
     */
    public boolean addService(Servicio service){
        boolean estado = ! services.contains(service);
        if(estado)services.add(service);
        return estado;
    }
}
