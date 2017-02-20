package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.models.Estilista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class EstilistasServiceStub implements EstilistaOperaciones{

    private static List<Estilista> estilistas = new ArrayList<>();

    @Override
    public List<Estilista> getEstilistas(){
        return estilistas;
    }

    @Override
    public void addEstilista(Estilista e) {

        if(e.getRolEstilista().equals("PROFESSIONAL")){
            estilistas.add(e);
        }

    }
}
