/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.interfaz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.eci.cosw.models.Cliente;
import edu.eci.cosw.models.Professional;
import java.sql.Blob;
import javax.persistence.Column;


/**
 *
 * @author 2101240
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              include = JsonTypeInfo.As.PROPERTY,
              property = "type")
@JsonSubTypes({
    @Type(value = Professional.class, name = "PROFESSIONAL"),
    @Type(value = Cliente.class, name = "CLIENTE")
    })

public interface Usuario {

    public int getIduser();

    public void setIduser(int id);

    public String getName();

    public void setName(String nombre);

    public String getIdCard();

    public void setIdCard(String cedula);

    public String getEmail();

    public void setEmail(String email);

    public String getPassword();

    public void setPassword(String password);

    public Blob getPhoto();

    public void setPhoto(Blob foto);

    public int getState();

    public void setState(int state);

    public String getRole();

    public void setRole(String Roles_idRole);

}
