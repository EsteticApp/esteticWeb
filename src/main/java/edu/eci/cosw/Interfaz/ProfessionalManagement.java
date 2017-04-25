package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Professional;
import edu.eci.cosw.models.Services;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by SYSTEM on 19/02/2017.
 */
public interface ProfessionalManagement {
    public List<Professional> getProfessionals() throws Exception;
    public List<Professional> getProfessionalsByCategory(String category) throws Exception;
    public List<Services> getServicesByProfessional(String professional) throws Exception;
    public Professional getProfessionalByEmail(String email) throws Exception;
    public List<Professional> getProfessionalByState(int state) throws Exception;
    public void updateProfessional(Professional p) throws Exception;
    public void addProfessional(Professional p) throws Exception;
}
