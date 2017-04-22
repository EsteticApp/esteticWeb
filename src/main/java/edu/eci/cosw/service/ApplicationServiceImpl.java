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
import edu.eci.cosw.models.Cliente;


/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ProfessionalRepositorio profesionalRepo;
    @Autowired
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
        System.out.println(usuario.getRole());
        if(usuario.getRole().equals("PROFESSIONAL")){
            System.out.println("Esta en profesional");
            profesionalRepo.save((Professional)usuario);
        }else{
            System.out.println("Esta en cliente");
            clienteRepo.save((Cliente)usuario);
        }
        
    }

    @Override
    public Usuario traerUsuario(String email) {
        Usuario pro=profesionalRepo.traerUsuario(email);
        if(pro==null){
            pro=clienteRepo.traerUsuario(email);
        }
        return pro;
    }
}
