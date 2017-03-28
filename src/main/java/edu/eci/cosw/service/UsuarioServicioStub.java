package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.UsuarioServicioOperaciones;
import edu.eci.cosw.models.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by estudiante on 3/28/17.
 */
@Service
public class UsuarioServicioStub implements UsuarioServicioOperaciones{

    private List<UsuarioServicio> precios;

    public UsuarioServicioStub(){
        precios = new ArrayList<>();
        precios.add(new UsuarioServicio(2, 1, "10000"));
        precios.add(new UsuarioServicio(2, 4, "50000"));
        precios.add(new UsuarioServicio(2, 7, "7000"));
    }

    @Override
    public List<UsuarioServicio> getPrecioServicios(){
        return precios;
    }

    @Override
    public void addPrecioServicio(String price){

    }
}
