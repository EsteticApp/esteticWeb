package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Professional;
import edu.eci.cosw.models.Services;

import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
public interface ProfessionalManagement {
    public List<Professional> getProfessionals() throws Exception;
    public List<Professional> getProfessionalsByCategory(String category) throws Exception;
    public List<Services> getServicesByProfessional(String professional) throws Exception;
    public void addProfessional(Professional p) throws Exception;
}
