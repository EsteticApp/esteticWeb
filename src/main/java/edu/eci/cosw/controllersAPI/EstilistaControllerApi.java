package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.models.Estilista;
import edu.eci.cosw.service.EstilistasServiceStub;
import org.apache.log4j.Logger;
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
@RequestMapping("/estilistas")
public class EstilistaControllerApi {

    @Autowired
    private EstilistaOperaciones estilista;


    @RequestMapping(method = RequestMethod.GET)
    public List<Estilista> getServicios() {
        return estilista.getEstilistas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public   ResponseEntity<?>  postSerivicio(@RequestBody Estilista e) {
        estilista.addEstilista(e);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
