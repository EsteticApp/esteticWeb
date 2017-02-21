package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Estilista;
import edu.eci.cosw.models.Servicio;

import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
public interface EstilistaOperaciones {
    public List<Estilista> getEstilistas();
    public List<Servicio> getServicesByStylist(String stylist);
    public void addEstilista(Estilista e);
}
