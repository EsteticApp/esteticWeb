/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

import edu.eci.cosw.Interfaz.Users;

/**
 *
 * @author ANDRES CAICEDO
 */
public class SimpleUsuario implements Users{

     private String nombre;
     private String email;
     private String role;

    public SimpleUsuario(String nombre, String email, String role) {
        this.nombre = nombre;
        this.email = email;
        this.role=role;
    }

    public SimpleUsuario() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
