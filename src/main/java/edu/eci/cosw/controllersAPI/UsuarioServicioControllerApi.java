package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.UsuarioServicioOperaciones;
import edu.eci.cosw.models.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by SYSTEM on 29/03/2017.
 */
@RestController
@RequestMapping("/precios")
public class UsuarioServicioControllerApi {

    @Autowired
    UsuarioServicioOperaciones usuarioServicio;


    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioServicio> getPriceServices() {
        return usuarioServicio.getPrecios(1, 1);
    }

    @RequestMapping(path = "/id", method = RequestMethod.GET)
    public ResponseEntity<?> getPriceById(@RequestBody UsuarioServicio us){
        try {
            System.out.println("Precio"+ us.getPrice());
            String precioServicios = usuarioServicio.getPrecioServicios(us.getUsers_iduser(), us.getServices_idServices());
            return new ResponseEntity<>(precioServicios, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No prices found", HttpStatus.NOT_FOUND);
        }
    }
}



