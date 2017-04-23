/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.User;

/**
 *
 * @author ANDRES CAICEDO
 */
public interface ApplicationService {
    public User getUsuario(String email, String password);
    public void setUsuario(User user);
    public User traerUsuario(String email);
}
