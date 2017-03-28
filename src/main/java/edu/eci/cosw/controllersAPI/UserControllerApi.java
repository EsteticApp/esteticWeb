/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.models.EmailString;
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
import java.util.logging.Level;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author 2101240
 */
@RestController
@RequestMapping("/app/user")
public class UserControllerApi {

    @Autowired
    ApplicationService users;

    @RequestMapping("/auteticacion")
    public Principal user(Principal user) {
       
        return user;
    }
   
    
    @RequestMapping(
            value = "/image/upload",
            method = RequestMethod.POST
    )
    public ResponseEntity uploadFile(MultipartHttpServletRequest request, @RequestParam(name = "email") EmailString email) {
        try {
            Iterator<String> itr = request.getFileNames();
            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                Usuario user=users.getUsuario(email.getEmail(), "");
                user.setPhoto(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
                //-->> GUARDAR EL DESPACHO A TRAVÉS DEL SERVICIO CREADO
                users.setUsuario(user);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    
    @RequestMapping(path = "/email", method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestBody EmailString email){
        try {
            System.out.println("Lllegua aquiiiii "+email);
            Usuario user= users.getUsuario(email.getEmail(),"");
            System.out.println(user.getName());
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/Registrar", method = RequestMethod.POST)
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
