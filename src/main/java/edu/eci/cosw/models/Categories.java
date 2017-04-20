package edu.eci.cosw.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by oscar on 19/04/17.
 */
@Entity
@Table(name = "categories")
public class Categories implements java.io.Serializable{

    private int idCategory;
    private String name;
    private Set<Services> services = new HashSet<>(0);

    public Categories() {
    }

    @Column(name = "idcategory", nullable = false)
    @GeneratedValue
    @Id
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = ALL)
    @JoinColumn(name="categories_idcategory", referencedColumnName="idCategory", nullable = false)
    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }
}
