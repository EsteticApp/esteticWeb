package edu.eci.cosw.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oscar on 19/04/17.
 */

@Entity
@Table(name = "professional")
public class Professional implements java.io.Serializable{

    private int idProfessional;
    private String name;
    private String email;
    private Blob photo;
    private String idCard;
    private String password;
    private int state;
    private String role;

    public Professional() {
    }

    @Column(name = "idprofessional", nullable = false)
    @GeneratedValue
    @Id
    public int getIdProfessional() {
        return idProfessional;
    }

    public void setIdProfessional(int idProfessional) {
        this.idProfessional = idProfessional;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "photo")
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Column(name = "idcard", nullable = false, length = 12)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Column(name = "role", nullable = false, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
