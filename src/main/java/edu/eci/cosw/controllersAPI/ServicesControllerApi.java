package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.ServiceManagement;
import edu.eci.cosw.models.Categoria;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Servicio;
import edu.eci.cosw.service.CategoriasServiceStub;
import edu.eci.cosw.service.ServiciesServiceImpl;

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
@RequestMapping("/servicios")
public class ServicesControllerApi {

    @Autowired
    private ServiceManagement services;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getServices() {
        try {
            List<Services> service = services.getServicios();
            List<String> data = new ArrayList<>();
            for(Services ser : service){
                data.add(ser.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            org.apache.log4j.Logger.getLogger(ServicesControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("No services found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postService(@RequestBody Categories c) {
        try {
            services.addServicio(c);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex){
            org.apache.log4j.Logger.getLogger(ServicesControllerApi.class.getName()).log(null, ex);
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }

    }
}
