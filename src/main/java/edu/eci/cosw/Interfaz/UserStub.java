/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.SimpleUsuario;
import edu.eci.cosw.models.Usuario;
import java.util.List;

/**
 *
 * @author ANDRES CAICEDO
 */
public interface UserStub {
    

    public List<Usuario> getUsers();
    public void addUser(Usuario user);
    public Usuario getUserByUsername(String username);
    public List<SimpleUsuario> getSimpleUsers();
    public Usuario getUserByEmail(String email);
    public Usuario loginUser(String name, String pass);
}
