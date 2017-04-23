/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.cosw.Interfaz.User;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Blob;

/**
 *
 * @author ANDRES CAICEDO
 */

@Service
@Entity
@Table(name = "professional")
public class Professional implements java.io.Serializable, User {

    private static final long serialVersionUID = 328754985741161521L;
    private int idProfessional;
    private String name;
    private String idCard;
    private String email;
    private String password;
    private String role;
    private Blob photo;
    private int state;

    public Professional(String nombre, String cedula, String email, String password, String role, Blob foto, int state) {
        this.name = nombre;
        this.idCard = cedula;
        this.email = email;
        this.password = password;
        this.role = role;
        this.photo = foto;
        this.state = state;
    }

    public Professional() {
    }

    @Column(name = "idprofessional")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int getId() {
        return idProfessional;
    }

    public void setId(int id) {
        this.idProfessional = id;
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

    @Column(name = "idcard")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String Roles_idRole) {
        this.role = Roles_idRole;
    }

}
