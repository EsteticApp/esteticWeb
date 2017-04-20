package edu.eci.cosw.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oscar on 19/04/17.
 */
@Entity
@Table(name = "reservations")
public class Reservations implements java.io.Serializable{
    private int idReservations;
    private Date reservationDate;
    private String phone;
    private String address;
    private ProfessionalHasServicesId professionalHasServicesId;

    public Reservations() {
    }

    @Column(name = "idreservations", nullable = false)
    @GeneratedValue
    @Id
    public int getIdReservations() {
        return idReservations;
    }

    public void setIdReservations(int idReservations) {
        this.idReservations = idReservations;
    }

    @Column(name = "reservationDate", nullable = false)
    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "address", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToOne (cascade = CascadeType.ALL)
    
    public ProfessionalHasServicesId getProfessionalHasServicesId() {
        return professionalHasServicesId;
    }

    public void setProfessionalHasServicesId(ProfessionalHasServicesId professionalHasServicesId) {
        this.professionalHasServicesId = professionalHasServicesId;
    }
}
