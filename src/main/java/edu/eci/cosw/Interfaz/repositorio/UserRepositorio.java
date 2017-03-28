/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANDRES CAICEDO
 */

public interface UserRepositorio extends JpaRepository<Usuario, Integer>{
    @Query("select distinct user from Usuario as user where email LIKE :email ")
  //@Query("from Usuario As u, Role As r  where u.email=:email")
  public Usuario traerUsuario(@Param("email") String email) ;
  
  


}