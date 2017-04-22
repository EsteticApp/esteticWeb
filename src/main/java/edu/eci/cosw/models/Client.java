package edu.eci.cosw.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by oscar on 19/04/17.
 */
@Entity
@Table(name = "client")
public class Client implements java.io.Serializable{
    private int idProfessional;
    private String name;
    private String email;
    private Blob photo;
    private String password;
    private String role;
    private Set<Reservations> reservations = new HashSet<>(0);

    public Client() {
    }

    public Client(int idProfessional, String name, String email, Blob photo, String password, String role) {
        this.idProfessional = idProfessional;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.role = role;
    }

    @Column(name = "idclient", nullable = false)
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

    @Column(name = "photo", nullable = false)
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = ALL)
    @JoinColumn(name="client_idclient", referencedColumnName="idclient", nullable=false)
    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }
}
