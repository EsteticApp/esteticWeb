/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;


import edu.eci.cosw.Interfaz.repositorio.ClienteRepositorio;
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
    private ProfessionalRepositorio profesionalRepo;
    private ClienteRepositorio clienteRepo;
   
    
    @Override
    public Usuario getUsuario(String email, String password) {
        System.out.println("pasa aqui");
        Usuario pro=profesionalRepo.traerUsuario(email);
        if(pro==null){
            pro=clienteRepo.traerUsuario(email);
        }
        return pro;
//        User usr = new User();
//        return usr.getUserByEmail(email);
       
    }    

    @Override
    public void setUsuario(Usuario usuario) {
        profesionalRepo.save((Professional)usuario);
    }

    @Override
    public Usuario traerUsuario(String email) {
        return profesionalRepo.traerUsuario(email);
    }
}
