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

/**
 *
 * @author 2101240
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{

    @Query("from Client cli where cli.email LIKE :email")
    public Client getClientByEmail(@Param("email") String email);
}
