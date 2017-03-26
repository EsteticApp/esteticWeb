/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.UserApp;
import edu.eci.cosw.models.Role;
import edu.eci.cosw.models.Usuario;
import edu.eci.cosw.service.ApplicationService;
import java.security.Principal;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sendgrid.*;

/**
 *
 * @author 2101240
 */
@RestController
public class UserControllerApi {

    @Autowired
    ApplicationService users;

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
       
        return user;
    }

    @RequestMapping(value = "app/Registrar", method = RequestMethod.POST)
    public ResponseEntity Registraruser(@RequestBody Usuario user) {
        try{

            System.out.println(user.getRoles_idRole().getNombre());
            System.out.println(user.getRoles_idRole().getIdRole());
            users.setUsuario(user);
        }catch (Exception e){
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
