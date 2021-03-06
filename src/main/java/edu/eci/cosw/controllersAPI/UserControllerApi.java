/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllersAPI;


import edu.eci.cosw.Interfaz.User;

import edu.eci.cosw.models.Professional;
import edu.eci.cosw.service.ApplicationService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
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
//    User users;


    @RequestMapping("/auteticacion")
    public Principal user(Principal user) {
        System.out.println("LLEGÖ");
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
                User user=users.getUsuario(email, "");
                System.out.println("Busca");
//                User user=users.getUserByEmail(email);
                System.out.println("deja de buscar");
                System.out.println(user.getId());
                System.out.println("Posible Error");
                user.setPhoto(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
                //-->> GUARDAR EL DESPACHO A TRAVÉS DEL SERVICIO CREADO
                users.setUsuario(user);
//                users.addUser(user);
                System.out.println(request);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    
   
    @RequestMapping(path = "/email", method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestBody String email){
        try {
            System.out.println("Lllegua aquiiiii "+email);
            User user= users.getUsuario(email,"");
//            User user= users.getUserByEmail(email.getEmail());
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ProfessionalsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No services found in that category", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/Registrar", method = RequestMethod.POST)
    public ResponseEntity Registraruser(@RequestBody User user) {
        try{
              System.out.println("Lllegua aquiiiii a registrar bien");
            System.out.println(user.getRole());
            System.out.println(user.getRole());
            users.setUsuario(user);
//            users.addUser(user);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody Professional user) {
        try{
            User us=users.getUsuario(user.getEmail(),"");
            Blob photo=us.getPhoto();
            user.setPhoto(photo);
            users.setUsuario(user);
//            users.addUser(user);
        }catch (Exception e){
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = "/{email}/image", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getQRCode(@PathVariable String email) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(new InputStreamResource(users.getUsuario(email,"").getPhoto().getBinaryStream()));
        } catch (Exception ex) {
            Logger.getLogger(UserControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/id/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientByEmailManagement(@PathVariable String email){
        try {
            ArrayList<Integer> id = new ArrayList<>();
            User u = users.traerUsuario(email);
            id.add(u.getId());
            return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(ClientsControllerApi.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No client found with that email", HttpStatus.NOT_FOUND);
        }
    }
}
