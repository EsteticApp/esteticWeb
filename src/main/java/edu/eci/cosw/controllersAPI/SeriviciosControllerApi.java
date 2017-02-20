package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.ServicioOperaciones;
import edu.eci.cosw.models.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/servicios")
public class SeriviciosControllerApi {

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
