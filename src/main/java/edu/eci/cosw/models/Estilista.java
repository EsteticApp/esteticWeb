package edu.eci.cosw.models;

import edu.eci.cosw.Stub.User;

import java.util.List;

/**
 * Created by estudiante on 2/16/17.
 */
public class Estilista{

    private Usuario rolEstilista;
    private List<Servicio> serviciosEstilista;

    public Estilista(Usuario rolEstilista, List<Servicio> serviciosEstilista){

        this.rolEstilista = rolEstilista;
        this.serviciosEstilista = serviciosEstilista;
    }

    public Usuario getRolEstilista(){

        return rolEstilista;
    }

    public void setRolEstilista(Usuario rolEstilista){

        this.rolEstilista = rolEstilista;
    }

    public List<Servicio> getServicios(){

        return serviciosEstilista;
    }



}
