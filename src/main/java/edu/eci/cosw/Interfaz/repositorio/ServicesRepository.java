package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by oscar on 19/04/17.
 */
public interface ServicesRepository extends JpaRepository<Services, Integer> {

//    select distinct * from services inner join categories on
//    services.categories_idcategory = categories.idcategory
//    where categories.name like "Peluqueria";
    @Query(value = "from Services serv")
    public List<Services> getServicesByCategory();
//    public List<Services> getServicesByCategory(String category);
}
