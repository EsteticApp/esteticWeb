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
    public List<Professional> getProfessionalsByCategory(int categoryId) throws Exception;
    public List<Services> getServicesByProfessional(int professionalId) throws Exception;
    public Professional getProfessionalByEmail(String email) throws Exception;
    public List<Professional> getProfessionalsByState(int state) throws Exception;
    public Professional getProfessionalState(int professionalID) throws Exception;
    public void updateProfessional(Professional p) throws Exception;
    public void addProfessional(Professional p) throws Exception;
}
