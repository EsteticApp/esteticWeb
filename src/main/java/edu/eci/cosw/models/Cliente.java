/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.cosw.interfaz.Usuario;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Blob;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author ANDRES CAICEDO
 */

@Service
@Entity
@Table(name = "client")
public class Cliente implements java.io.Serializable, Usuario {

    private static final long serialVersionUID = 328754985741161521L;
    private int iduser;
    private String name;
    
    private String email;
    private String password;
    private String role;
    private Blob photo;
    

    public Cliente(String nombre, String email, String password, String role, Blob foto) {
        this.name = nombre;
        
        this.email = email;
        this.password = password;
        this.role = role;
        this.photo = foto;
        
    }

    public Cliente() {
    }

    @Column(name = "idcliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int id) {
        this.iduser = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
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

    @JsonIgnore
    @Column(name = "photo")
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob foto) {
        this.photo = foto;
    }


    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String Roles_idRole) {
        this.role = Roles_idRole;
    }

    @Override
    public String getIdCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdCard(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(int state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
