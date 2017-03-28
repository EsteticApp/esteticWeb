package edu.eci.cosw.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by estudiante on 2/16/17.
 */
public class Reserva {

    private Date reservationDate;
    private Time requestDate;
    private int iduser;
    private int phone;
    private String address;
    private List<Servicio> servicios;
    private String state;
    private Double reservationPrice;
    private int idreserva;

    public Reserva(int idreserva,int iduser,Date reservationDate, Time requestDate, int phone, String address, List<Servicio> servicios, String state, Double reservationPrice) {
        this.reservationDate = reservationDate;
        this.requestDate = requestDate;
        this.iduser = iduser;
        this.phone = phone;
        this.address = address;
        this.servicios = servicios;
        this.state = state;
        this.reservationPrice = reservationPrice;
        this.idreserva = idreserva;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Time getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Time requestDate) {
        this.requestDate = requestDate;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(Double reservationPrice) {
        this.reservationPrice = reservationPrice;
    }


}
