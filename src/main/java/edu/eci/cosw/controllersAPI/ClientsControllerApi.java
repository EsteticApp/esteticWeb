package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ClientManagement;
import edu.eci.cosw.Interfaz.repositorio.ClientRepository;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Client;
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
 * Created by oscar on 22/04/17.
 */
@RestController
@RequestMapping("/clients")
public class ClientsControllerApi {
    @Autowired
    private ClientManagement clientManagement;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getClientsManagement(){
        try {
            List<Client> clientList = clientManagement.getClients();
            List<String> data = new ArrayList<>();
            for(Client c : clientList){
                data.add(c.getName());
            }
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasServiceStub.class.getName()).log(null, ex);
            return new ResponseEntity<>("No clients found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientByEmailManagement(@PathVariable String email){
        try {
            Client client = clientManagement.getClientByEmail(email);
            return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServicesControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No client found with that email", HttpStatus.NOT_FOUND);
        }
    }
}
