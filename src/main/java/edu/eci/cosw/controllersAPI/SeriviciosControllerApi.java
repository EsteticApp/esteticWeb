package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.service.ServiciosStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/servicios")
public class SeriviciosControllerApi {

    /*@Autowired
    ServiciosStub servicios = new ServiciosStub();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getServiciosManagement(){
        try {
            return new ResponseEntity<>(servicios.getServicios(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No services found", HttpStatus.NOT_FOUND);
        }
    }*/
}
