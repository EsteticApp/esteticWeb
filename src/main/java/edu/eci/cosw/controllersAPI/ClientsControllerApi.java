package edu.eci.cosw.controllersAPI;

import edu.eci.cosw.Interfaz.ClientManagement;
import edu.eci.cosw.models.Client;
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
 * Created by oscar on 22/04/17.
 */
@RestController
@RequestMapping("/clientes")
public class ClientsControllerApi {

    @Autowired
    private ClientManagement clientManagement;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getClientsManagement(){
        try {
            List<Client> data = clientManagement.getClients();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ClientsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No clients found", HttpStatus.NOT_FOUND);
        }
    }

    //Obtiene los datos de un cliente dado
    @RequestMapping(path = "/id/{clientID}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientByEmailManagement(@PathVariable int clientID){
        try {
            Client client = clientManagement.getClientByEmail(clientID);
            return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ClientsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No client found with that email", HttpStatus.NOT_FOUND);
        }
    }
}
