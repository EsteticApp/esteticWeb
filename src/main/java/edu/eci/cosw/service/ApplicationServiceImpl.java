/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;

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

    @Override
    public Usuario getUsuario(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Autowired
    private UserRepositorio userRepo;
    
    
    @Override
    public Usuario getUsuario(String email, String password) {
        return userRepo.traerUsuario(email);
    }*/
    
}
