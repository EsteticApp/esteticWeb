/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.repositorio.RoleRepositorio;
import edu.eci.cosw.Interfaz.repositorio.UserRepositorio;
import edu.eci.cosw.models.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private UserRepositorio userRepo;
    @Autowired
    private RoleRepositorio roleRepo;
    
    @Override
    public Usuario getUsuario(String email, String password) {
        System.out.println("pasa aqui");
        return userRepo.traerUsuario(email);
       
    }    

    @Override
    public void setUsuario(Usuario usuario) {
        userRepo.save(usuario);
    }
}
