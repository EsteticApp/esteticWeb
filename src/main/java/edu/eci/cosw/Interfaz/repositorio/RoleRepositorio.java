/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author estudiante
 */
public interface RoleRepositorio extends JpaRepository<Role,Integer>{
    
}
