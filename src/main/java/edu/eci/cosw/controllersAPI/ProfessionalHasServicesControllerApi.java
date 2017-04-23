package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ProfessionalHasServiceManagement;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.ProfessionalHasServices;
import edu.eci.cosw.service.CategoriasServiceStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by SYSTEM on 29/03/2017.
 */
@RestController
@RequestMapping("/precios")
public class ProfessionalHasServicesControllerApi {

    @Autowired
    ProfessionalHasServiceManagement phsManagement;

    //Obtiene toda la lista de la tabla Professional_Has_Service
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getPHSsManagement() {
        try {
            List<ProfessionalHasServices> phsList = phsManagement.getPHSs();
            return new ResponseEntity<>(phsList, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasServiceStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No professionals have registered their services", HttpStatus.NOT_FOUND);
        }

        //return usuarioServicio.getPrecios(1, 1);
    }

    // Obtiene un elemento específico de la tabla Professional_Has_Service
    @RequestMapping(path = "/id/{idPro}.{idSer}", method = RequestMethod.GET)
    public ResponseEntity<?> getPHSManagement(@PathVariable int idPro, @PathVariable int idSer){
        try {
            ProfessionalHasServices phs = phsManagement.getSpecificPHS(idPro, idSer);
            return new ResponseEntity<>(phs, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalHasServicesControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No element matches these values", HttpStatus.NOT_FOUND);
        }
    }

    // Obtiene el valor de el servicio indicado para ese profesional
    @RequestMapping(path = "/precio/{idPro}.{idSer}", method = RequestMethod.GET)
    public ResponseEntity<?> getPHSPriceByIdManagement(@PathVariable int idPro, @PathVariable int idSer){
        try {
            ProfessionalHasServices phs = phsManagement.getSpecificPHS(idPro, idSer);
            return new ResponseEntity<>(phs.getPrice(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalHasServicesControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No element matches these values", HttpStatus.NOT_FOUND);
        }
    }
}



