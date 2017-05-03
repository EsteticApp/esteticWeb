package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 2094687 on 4/20/17.
 */
public interface ReservationRepository  extends JpaRepository<Reservations, Integer> {

    @Query(value = "from Reservations res where res.state like ?1")
    public List<Reservations> getReservationByState(String state);

    @Query(value = "select cli.reservations from Client cli where cli.id like ?1")
    public List<Reservations> getReservationByClient(int clientID);

    @Query(value = "from Reservations res where res.idProfessional like ?1")
    public List<Reservations> getReservationByProfessional(int professionalID);
}
