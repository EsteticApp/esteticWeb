/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;


import edu.eci.cosw.models.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.cosw.Interfaz.repositorio.ProfessionalRepositorio;
import edu.eci.cosw.interfaz.Usuario;


/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ProfessionalRepositorio userRepo;
   
    
    @Override
    public Usuario getUsuario(String email, String password) {
        System.out.println("pasa aqui");
        return userRepo.traerUsuario(email);
//        User usr = new User();
//        return usr.getUserByEmail(email);
       
    }    

    @Override
    public void setUsuario(Usuario usuario) {
        userRepo.save((Professional)usuario);
    }

    @Override
    public Usuario traerUsuario(String email) {
        return userRepo.traerUsuario(email);
    }
}
