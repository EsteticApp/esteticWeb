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

public interface ProfessionalRepository extends JpaRepository<Professional, Integer>{

    @Query("from Professional pro where pro.id = ?1")
    public Professional getProfessionalByID(int professionalID);

    @Query("from Professional pro where pro.email like ?1")
    public Professional getProfessionalByEmail(String email);

    @Query(value = "from Professional pro where pro.state = ?1")
    public List<Professional> getProfessionalsByState(int professionalState);
}
