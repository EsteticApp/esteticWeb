/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Professional;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANDRES CAICEDO
 */

public interface ProfessionalRepositorio extends JpaRepository<Professional, Integer>{
    @Query("select distinct user from Professional as user where email LIKE :email ")
  //@Query("from Usuario As u, Role As r  where u.email=:email")
  public Professional traerUsuario(@Param("email") String email);

    @Query("select distinct user from Professional as user where role = PROFESSIONAL")
    public List<Professional> getStylist();

    @Query("select distinct user from Professional as user where role = PROFESSIONAL")
    public List<Professional> getStylistByCategory();
}
