package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Servicio;
import edu.eci.cosw.models.UsuarioServicio;

import java.util.List;

/**
 * Created by 2094687 on 2/20/17.
 */
public interface UsuarioServicioOperaciones {

    public List<UsuarioServicio> getPrecioServicios();
    public void addPrecioServicio(String price);
}
