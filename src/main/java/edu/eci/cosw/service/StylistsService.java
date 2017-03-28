package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.Interfaz.repositorio.UserRepositorio;
import edu.eci.cosw.models.Estilista;
import edu.eci.cosw.models.Servicio;
import edu.eci.cosw.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2094687 on 3/28/17.
 */

public class StylistsService implements EstilistaOperaciones {

    @Autowired
    UserRepositorio userRepositorio;

    @Override
    public List<Estilista> getEstilistas() throws Exception {
        List<Usuario> users = new ArrayList<>();
        try{
            users = userRepositorio.getStylist();
        }catch(Exception e){
            System.out.println("=====================================");
            System.out.println("Error en la conexión con la BD");
            System.out.println("=====================================");
        }
        List<Estilista> stylists = new ArrayList<>();
        for(Usuario usr : users){
            stylists.add(new Estilista(usr));
        }
        if(stylists.size() == 0) throw new Exception();
        return stylists;
    }

    @Override
    public List<Estilista> getStylistsByCategory(String category) throws Exception {
        return null;
    }

    @Override
    public List<Servicio> getServicesByStylist(String stylist) throws Exception {
        return null;
    }

    @Override
    public void addEstilista(Estilista e) {

    }
}
