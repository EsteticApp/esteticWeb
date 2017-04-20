package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 2094687 on 4/20/17.
 */
public interface ReservationRepository  extends JpaRepository<Reservations, Integer> {
}
