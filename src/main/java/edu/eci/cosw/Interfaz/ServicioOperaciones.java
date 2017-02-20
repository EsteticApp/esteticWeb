package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Servicio;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
public interface ServicioOperaciones {
    public List<Servicio> getServicios();
    public List<Servicio> getServiciosByCategory(String category);
    public void addServicio(Servicio s);
}
