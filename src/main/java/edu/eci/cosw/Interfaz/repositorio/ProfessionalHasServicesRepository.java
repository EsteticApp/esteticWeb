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

    @Query(value = "from ProfessionalHasServices phs where phs.services.name like ?1")
    public List<ProfessionalHasServices> getPHSsByService(String service);

    // En espera de la confirmación de la ID del profesional ~oscar-beltran
    @Query(value = "from ProfessionalHasServices phs where phs.professional.name like ?1")
    public List<ProfessionalHasServices> getPHSsByProfessional(String professional);
}
