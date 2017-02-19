/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

/**
 *
 * @author ANDRES CAICEDO
 */
public class Usuario {
     private String nombre;
     private int cedula;
     private String email;
     private String password;
     private String role;

    public Usuario(String nombre, int cedula, String email, String password, String role) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.password = password;
        this.role=role;
    }

    public Usuario() {
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
     
     
}
