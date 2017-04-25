package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ProfessionalManagement;
import edu.eci.cosw.models.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 22/04/2017.
 */

public class ProfessionalsServiceStub implements ProfessionalManagement {

    private List<Professional> professionals;

    @Override
    public List<Professional> getProfessionals() throws Exception{
        if(professionals == null) fillProfessionals();
        if(professionals.isEmpty())throw new Exception();
        return professionals;
    }

    @Override
    public List<Professional> getProfessionalsByCategory(String category) throws Exception{
        List<Professional> professionalList = new ArrayList<>();
        professionalList.add(new Professional("Pepito " + category, "1", "pepito@mail.com", "123456", "PROFESSIONAL", null, 0));
        if(professionalList.isEmpty())throw new Exception();
        return professionalList;
    }

    @Override
    public List<Services> getServicesByProfessional(String professional) throws Exception{
        List<Services> services = new ArrayList<>();
        services.add(new Services("Servicio inventado para el profesional " + professional));
        if(services.isEmpty())throw new Exception();
        return services;
    }

    @Override
    public List<Professional> getProfessionalByState(int state) throws Exception {
        return null;
    }

    @Override
    public Professional getProfessionalByEmail(String email) throws Exception {
        return null;
    }

    @Override
    public void updateProfessional(Professional p) throws Exception {

    }

    @Override
    public void addProfessional(Professional p) throws Exception{
        if(professionals == null) professionals = new ArrayList<>();
        professionals.add(p);
    }

    private void fillProfessionals(){
        professionals = new ArrayList<>();
        professionals.add(new Professional("Profesional 1","123","profesional1@mail.com","1234", "PROFESSIONAL", null,0));
        professionals.add(new Professional("Profesional 2","456","profesional2@mail.com","1234", "PROFESSIONAL", null,0));
        professionals.add(new Professional("Profesional 3","789","profesional3@mail.com","1234", "PROFESSIONAL", null,0));
        professionals.add(new Professional("Profesional 4","101","profesional4@mail.com","1234", "PROFESSIONAL", null,0));
    }
}
