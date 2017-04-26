package edu.eci.cosw.Interfaz.repositorio;

import edu.eci.cosw.models.ProfessionalHasServices;
import edu.eci.cosw.models.ProfessionalHasServicesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by oscar on 22/04/17.
 */
public interface ProfessionalHasServicesRepository extends JpaRepository<ProfessionalHasServices, ProfessionalHasServicesId> {

    @Query(value = "from ProfessionalHasServices phs where phs.services.idServices = ?1")
    public List<ProfessionalHasServices> getPHSsByServiceID(int serviceID);

    @Query(value = "from ProfessionalHasServices phs where phs.professional.id = ?1")
    public List<ProfessionalHasServices> getPHSsByProfessionalID(int professionalID);
}
