/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;

import edu.eci.cosw.interfaz.Usuario;
import edu.eci.cosw.models.Professional;

import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANDRES CAICEDO
 */
public interface ApplicationService {
    public Usuario getUsuario(String email, String password);
    public void setUsuario(Usuario usuario);
    public  Usuario traerUsuario(String email);
}
