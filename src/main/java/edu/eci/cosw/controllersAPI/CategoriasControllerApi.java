package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.service.CategoriasServiceStub;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;

/**
 * Controlador de categorias relacionadas con servicios
 * @author Deivan Oliva
 */

@RestController
@RequestMapping("/categorias")
public class CategoriasControllerApi {

    @Autowired
    CategoriasServiceStub categorias = new CategoriasServiceStub();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriasManagement(){
        try {
            return new ResponseEntity<>(categorias.getCategorias(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasServiceStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No categories found", HttpStatus.NOT_FOUND);
        }
    }

}
