/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

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
@Table(name = "users")
public class Usuario implements java.io.Serializable {

    private static final long serialVersionUID = 328754985741161521L;
    private int iduser;
    private String name;
    private String idCard;
    private String email;
    private String password;
    private Role roles_idRole;
    private Blob photo;
    private int state;

    public Usuario(String nombre, String cedula, String email, String password, Role role, Blob foto, int state) {
        this.name = nombre;
        this.idCard = cedula;
        this.email = email;
        this.password = password;
        this.roles_idRole = role;
        this.photo = foto;
        this.state = state;
    }

    public Usuario() {
    }

    @Column(name = "iduser")
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

    @Column(name = "idcard")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String cedula) {
        this.idCard = cedula;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Roles_idrole", referencedColumnName = "idrole", nullable = false)
//    @Column(name = "roles_idrole", nullable = false)
    public Role getRoles_idRole() {
        return roles_idRole;
    }

    public void setRoles_idRole(Role Roles_idRole) {
        this.roles_idRole = Roles_idRole;
    }

}
