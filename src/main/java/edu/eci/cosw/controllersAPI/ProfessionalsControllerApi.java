package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.ProfessionalManagement;
import edu.eci.cosw.models.Professional;
import edu.eci.cosw.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/estilistas")
public class ProfessionalsControllerApi {

    @Autowired
    private ProfessionalManagement professional;

    // GETs Methods

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalManagement(){
        try {
            List<Professional> data = professional.getProfessionals();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/services/{professionalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getServicesByProfessionalManagement(@PathVariable int professionalId){
        try {
            List<Services> services = this.professional.getServicesByProfessional(professionalId);
            List<String> data = new ArrayList<>();
            for(Services s : services){
                data.add(s.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found for that professional", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/category/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsByCategoryManagement(@PathVariable int categoryId){
        try {
            List<Professional> data = professional.getProfessionalsByCategory(categoryId);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsByStateManagement(@PathVariable int state){
        try {
            List<Professional> data = professional.getProfessionalsByState(state);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found with that state", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/estilista/state/{professionalID}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsStateManagement(@PathVariable int professionalID){
        try {
            Professional pro = professional.getProfessionalState(professionalID);
            List<Integer> integers  = new ArrayList<>();
            integers.add(pro.getState());
            return new ResponseEntity<>(integers, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found for that professional", HttpStatus.NOT_FOUND);
        }
    }

    // POSTs Methods

    @RequestMapping(method = RequestMethod.POST)
    public   ResponseEntity<?> postProfessional (@RequestBody Professional p) {
        try {
            professional.addProfessional(p);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex){
//            Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/estilista/state", method = RequestMethod.POST)
    public   ResponseEntity<?> postUpdateProfessional (@RequestBody List<String> state) {
        try {
            int s = Integer.parseInt(state.get(0));
            Professional profe = professional.getProfessionalByEmail(state.get(1));
            profe.setState(s);
            professional.updateProfessional(profe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
//            Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(null);
            return new ResponseEntity<>("An error has occurred", HttpStatus.NOT_FOUND);
        }
    }
}