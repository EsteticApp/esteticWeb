/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.UserApp;
import edu.eci.cosw.models.Usuario;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2101240
 */
@RestController
public class UserControllerApi {

    @Autowired
    Usuario usersStub;

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        System.out.println("Entra por aca");
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "app/Registrar", method = RequestMethod.POST)
    public ResponseEntity<?> Registraruser(@RequestBody Usuario user) {
        //usersStub.addUser(user);
        System.out.println("Entro Aqui!!!!");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
