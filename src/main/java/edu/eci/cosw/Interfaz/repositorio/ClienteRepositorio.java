/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Cliente;
import edu.eci.cosw.models.Professional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2101240
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    @Query("select distinct user from Cliente as user where email LIKE :email ")
  //@Query("from Usuario As u, Role As r  where u.email=:email")
  public Cliente traerUsuario(@Param("email") String email);

    @Query("select distinct user from Cliente as user where role = CLIENTE")
    public List<Cliente> getStylist();

    @Query("select distinct user from Cliente as user where role = CLIENTE")
    public List<Cliente> getStylistByCategory();
    
}
