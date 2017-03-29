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
import edu.eci.cosw.models.ImageEmailString;
import edu.eci.cosw.service.User;
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
//    ApplicationService users;
    User users;

    @RequestMapping("/auteticacion")
    public Principal user(Principal user) {
       
        return user;
    }
   
    
    @RequestMapping(
            value = "/image/upload",
            method = RequestMethod.POST
    )
    public ResponseEntity uploadFile(MultipartHttpServletRequest request, @RequestParam(name = "email") String email) {
//        MultipartHttpServletRequest request=emailimagen.getRequest();
//        EmailString email=emailimagen.getEmail();

        try {
            Iterator<String> itr = request.getFileNames();
            System.out.println(email);
            System.out.println("llega");
            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                System.out.println("hace algo aqui");
//                Usuario user=users.getUsuario(email.getEmail(), "");
                System.out.println("Busca");
                Usuario user=users.getUserByEmail(email);
                System.out.println("deja de buscar");
                System.out.println(user.getIduser());
                System.out.println("Posible Error");
                user.setPhoto(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
                //-->> GUARDAR EL DESPACHO A TRAVÉS DEL SERVICIO CREADO
//                users.setUsuario(user);
                users.addUser(user);
                System.out.println(request);
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
//            Usuario user= users.getUsuario(email.getEmail(),"");
            Usuario user= users.getUserByEmail(email.getEmail());
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EstilistaControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/Registrar", method = RequestMethod.POST)
    public ResponseEntity Registraruser(@RequestBody Usuario user) {
        try{
              System.out.println("Lllegua aquiiiii a registrar bien");
            System.out.println(user.getRoles_idRole().getNombre());
            System.out.println(user.getRoles_idRole().getIdRole());
//            users.setUsuario(user);
            users.addUser(user);
        }catch (Exception e){
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
