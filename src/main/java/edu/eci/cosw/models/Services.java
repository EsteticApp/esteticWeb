package edu.eci.cosw.models;

import javax.persistence.*;

/**
 * Created by oscar on 19/04/17.
 */
@Entity
@Table(name = "services")
public class Services implements java.io.Serializable{

    private int idServices;
    private String name;

    public Services() {
    }

    @Column(name = "idservices", nullable = false)
    @GeneratedValue
    @Id
    public int getIdServices() {
        return idServices;
    }

    public void setIdServices(int idServices) {
        this.idServices = idServices;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
