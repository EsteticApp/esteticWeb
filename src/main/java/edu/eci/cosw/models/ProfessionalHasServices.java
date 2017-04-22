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
    private Services services;
    private Professional professional;
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

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "services_idservices", referencedColumnName="idservices", insertable = false, updatable = false, nullable=false)
    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "professional_idprofessional", referencedColumnName="idprofessional", insertable = false, updatable = false, nullable=false)
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    @Column(name = "price", nullable = false, length = 45)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
