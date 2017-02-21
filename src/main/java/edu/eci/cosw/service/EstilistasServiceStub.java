package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.Stub.User;
import edu.eci.cosw.models.Estilista;
import edu.eci.cosw.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import edu.eci.cosw.Interfaz.UserApp;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class EstilistasServiceStub implements EstilistaOperaciones{

    private static List<Estilista> estilistas = new ArrayList<>();
    @Autowired
    private UserApp user;
    @Override
    public List<Estilista> getEstilistas(){
        //Estilistas quemados
        List<Usuario> users = user.getUsers();
        for(Usuario usr : users){
            if(usr.getRole().equals("PROFESSIONAL")){
                estilistas.add(new Estilista(usr, null));
            }
        }
        return estilistas;
    }

    @Override
    public void addEstilista(Estilista e) {

        if(e.getRolEstilista().equals("PROFESSIONAL")){
            estilistas.add(e);
        }

    }
}
