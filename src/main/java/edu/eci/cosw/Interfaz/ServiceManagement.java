package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Servicio;
import java.util.List;

/**
 * Created by 2094687 on 19/02/2017.
 */
public interface ServiceManagement {
    public List<Services> getServicios() throws Exception;
    public void addServicio(Services s) throws Exception;
}
