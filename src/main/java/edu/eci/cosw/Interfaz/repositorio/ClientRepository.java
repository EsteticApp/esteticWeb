/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author 2101240
 */
public interface ClientRepository extends JpaRepository<Client, String>{

    //@Query("from Client cli where cli.email LIKE :email")
    //@Query("select distinct user from Client as user where email like ?1")
    @Query(value = "from Client client where client.id = ?1")
    public Client getClientByID(int clientID);

    @Query(value = "from Client client where client.email = ?1")
    public Client getClientByEmail(String email);

}
