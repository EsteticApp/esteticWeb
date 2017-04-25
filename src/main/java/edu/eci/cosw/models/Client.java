package edu.eci.cosw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.cosw.Interfaz.User;
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
public class Client implements java.io.Serializable, User {
    private int id;
    private String name;
    private String email;
    private Blob photo;
    private String password;
    private String role;
    private Set<Reservations> reservations = new HashSet<>(0);

    public Client() {
    }

    public Client(String name, String email, String password, Blob photo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.role = "CLIENT";
    }

    public Client(int idClient, String name, String email, Blob photo, String password, String role) {
        this.id = idClient;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.role = role;
    }

    @Column(name = "idclient", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int getId() {
        return id;
    }

    @Override
    public void setId(int idClient) {
        this.id = idClient;
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

    @JsonIgnore
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


    @Transient
    public String getIdCard() {
        return null;
    }

    @Override
    public void setIdCard(String cedula) {

    }

    @Transient
    @Override
    public int getState() {
        return -1;
    }

    @Override
    public void setState(int state) {

    }
}
