package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Estilista;

import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
public interface EstilistaOperaciones {
    public List<Estilista> getEstilistas();
    public void addEstilista(Estilista e);
}
