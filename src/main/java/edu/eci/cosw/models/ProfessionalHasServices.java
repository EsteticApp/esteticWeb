package edu.eci.cosw.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by oscar on 19/04/17.
 */
@Entity
@Table(name = "professional_has_services")
public class ProfessionalHasServices implements java.io.Serializable{

    private ProfessionalHasServicesId id;
    private String price;

    public ProfessionalHasServices() {
    }

    @EmbeddedId
    public ProfessionalHasServicesId getId() {
        return id;
    }

    public void setId(ProfessionalHasServicesId id) {
        this.id = id;
    }

    @Column(name = "price", nullable = false, length = 45)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
