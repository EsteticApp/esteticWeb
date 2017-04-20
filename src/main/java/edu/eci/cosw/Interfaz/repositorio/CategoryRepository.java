package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oscar on 19/04/17.
 */
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
}
