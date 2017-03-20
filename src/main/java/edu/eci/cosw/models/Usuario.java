/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

import edu.eci.cosw.Interfaz.Users;
import java.sql.Blob;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ANDRES CAICEDO
 */
@Entity
@Table(name="users")
public class Usuario implements java.io.Serializable{
    
    private static final long serialVersionUID = 328754985741161521L;
     private int id;
     private String nombre;
     private int cedula;
     private String email;
     private String password;
     private Role role;
     private Blob foto;

    public Usuario(int id, String nombre, int cedula, String email, String password, Role role, Blob foto) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.password = password;
        this.role = role;
        this.foto = foto;
    }

    
    
    public Usuario() {
    }

    @Column(name="iduser")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name = "state", nullable = false)
    public int getCedula() {
        return cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Role getRole() {
        return role;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name = "Roles_idRole", referencedColumnName = "idRole",nullable = false,insertable = false,updatable = false)
    })
    public void setRole(Role role) {
        this.role = role;
    }
    @Column(name = "photo", nullable = false)
    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    

}
