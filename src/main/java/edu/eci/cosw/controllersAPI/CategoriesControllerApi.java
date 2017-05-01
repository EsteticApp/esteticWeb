package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import edu.eci.cosw.service.CategoriasServiceStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Controlador de categories relacionadas con servicios
 * @author Deivan Oliva
 */

@RestController
@RequestMapping("/categorias")
public class CategoriesControllerApi {

    @Autowired
    CategoryManagement categories;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriesManagement(){
        try {
            List<Categories> categoriesList = categories.getCategories();
            List<String> data = new ArrayList<>();
            for(Categories c : categoriesList){
                data.add(c.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            Logger.getLogger(CategoriasServiceStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No categories found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/services/{categoryID}", method = RequestMethod.GET)
    public ResponseEntity<?> getServiceByCategoryManagement(@PathVariable int categoryID){
        try {
            List<Services> servicesList = categories.getServicesByCategory(categoryID);
            List<String> data = new ArrayList<>();
            for(Services s : servicesList){
                data.add(s.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ServicesControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }
}
