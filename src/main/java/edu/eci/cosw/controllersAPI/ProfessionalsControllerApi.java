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

/**
 * Created by SYSTEM on 19/02/2017.
 */

@RestController
@RequestMapping("/estilistas")
public class ProfessionalsControllerApi {

    @Autowired
    private ProfessionalManagement professional;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalManagement(){
        try {
            List<Professional> data = professional.getProfessionals();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found", HttpStatus.NOT_FOUND);
        }
    }

    // Hay que indicar cuál será la identificación, ¿la de BD o el nombre?
    // Por el momento la dejaré como el nombre ~oscar-beltran
    @RequestMapping(path = "/id/{professional}", method = RequestMethod.GET)
    public ResponseEntity<?> getServicesByProfessionalManagement(@PathVariable String professional){
        try {
            List<Services> services = this.professional.getServicesByProfessional(professional);
            List<String> data = new ArrayList<>();
            for(Services s : services){
                data.add(s.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found for that professional", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{category}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsByCategoryManagement(@PathVariable String category){
        try {
            List<Professional> data = professional.getProfessionalsByCategory(category);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public   ResponseEntity<?> postProfessional (@RequestBody Professional p) {
        try {
            professional.addProfessional(p);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex){
            org.apache.log4j.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }
    }

    // Actualización estado

    @RequestMapping(path = "/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsByStateManagement(@PathVariable int state){
        try {
            List<Professional> data = professional.getProfessionalByState(state);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No professionals found with that state", HttpStatus.NOT_FOUND);
        }
    }

    // Hay que indicar cuál será la identificación, ¿la de BD o el nombre?
    // Por el momento la dejaré como el nombre ~oscar-beltran
    @RequestMapping(path = "/{email}/state", method = RequestMethod.GET)
    public ResponseEntity<?> getProfessionalsStateManagement(@PathVariable String email){
        try {
            Professional pro = professional.getProfessionalByEmail(email);
            List<Integer> integers  = new ArrayList<>();
            integers.add(pro.getState());
            return new ResponseEntity<>(integers, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found for that professional", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update/state", method = RequestMethod.POST)
    public   ResponseEntity<?> postUpdateProfessional (@RequestBody List<String> state) {
        try {
            int s = Integer.parseInt(state.get(0));
            Professional profe = professional.getProfessionalByEmail(state.get(1));
            profe.setState(s);
            professional.updateProfessional(profe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            org.apache.log4j.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("An error has occurred", HttpStatus.NOT_FOUND);
        }
    }

}