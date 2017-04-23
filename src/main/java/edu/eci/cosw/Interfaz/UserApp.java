/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz;


import java.util.List;

/**
 *
 * @author ANDRES CAICEDO
 */
public interface UserApp {
    

    public List<User> getUsers();
    public void addUser(User user);
    public User getUserByUsername(String username);
    public List<User> getSimpleUsers();
    public User getUserByEmail(String email);
    public User loginUser(String name, String pass);
}
