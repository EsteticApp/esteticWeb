package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.UsuarioServicioOperaciones;
import edu.eci.cosw.models.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by estudiante on 3/28/17.
 */
@RestController
@RequestMapping("/precios")
public class UsuarioServicioControllerApi {

    @Autowired
    UsuarioServicioOperaciones usuarioServicio;


    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioServicio> getPrecio() {
        return usuarioServicio.getPrecioServicios();
    }




}

