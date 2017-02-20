package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.ServicioOperaciones;
import edu.eci.cosw.models.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/servicios")
public class ServiciosControllerApi {

    @Autowired
    private ServicioOperaciones servicio;


    @RequestMapping(method = RequestMethod.GET)
    public List<Servicio> getServicios() {
        return servicio.getServicios();
    }

    @RequestMapping(method = RequestMethod.POST)
    public   ResponseEntity<?>  postSerivicio(@RequestBody Servicio s) {
        servicio.addServicio(s);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
