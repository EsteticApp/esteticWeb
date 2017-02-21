package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.models.Estilista;
import edu.eci.cosw.models.Servicio;
import edu.eci.cosw.service.EstilistasServiceStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/estilistas")
public class EstilistaControllerApi {

    @Autowired
    private EstilistaOperaciones estilista;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStylistManagement(){
        try {
            List<Estilista> data = estilista.getEstilistas();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No stylist found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{stylist}", method = RequestMethod.GET)
    public ResponseEntity<?> getServicesByStylistManagement(@PathVariable String stylist){
        try {
            List<Servicio> data = estilista.getServicesByStylist(stylist);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public   ResponseEntity<?>  postSerivicio(@RequestBody Estilista e) {
        estilista.addEstilista(e);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
