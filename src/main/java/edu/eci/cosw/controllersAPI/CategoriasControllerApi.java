package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.models.Servicio;
import edu.eci.cosw.service.CategoriasServiceStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;

/**
 * Controlador de categorias relacionadas con servicios
 * @author Deivan Oliva
 */

@RestController
@RequestMapping("/categorias")
public class CategoriasControllerApi {

    @Autowired
    CategoryManagement categorias;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriesManagement(){
        try {
            return new ResponseEntity<>(categorias.getCategoriesName(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasServiceStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No categories found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{category}", method = RequestMethod.GET)
    public ResponseEntity<?> getTaskByPriorityManagement(@PathVariable String category){
        try {
            List<Servicio> data = categorias.getServicesByCategory(category);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServiciosControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }

}