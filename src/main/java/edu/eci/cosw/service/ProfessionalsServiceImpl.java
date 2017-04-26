package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ProfessionalManagement;
import edu.eci.cosw.Interfaz.repositorio.ProfessionalHasServicesRepository;
import edu.eci.cosw.Interfaz.repositorio.ServicesRepository;
import edu.eci.cosw.models.ProfessionalHasServices;
import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Professional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import edu.eci.cosw.Interfaz.repositorio.ProfessionalRepository;
import org.springframework.stereotype.Service;

/**
 * Created by 2094687 on 3/28/17.
 */
@Service
public class ProfessionalsServiceImpl implements ProfessionalManagement {

    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private ProfessionalHasServicesRepository phsRepo;
    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<Professional> getProfessionals() throws Exception {
        List<Professional> professionalList = professionalRepository.findAll();
        if(professionalList.size() == 0) throw new Exception();
        return professionalList;
    }

    @Override
    public List<Professional> getProfessionalsByCategory(int categoryId) throws Exception {
        List<Services> servicesList = servicesRepository.getServicesByCategory(categoryId);
        List<Professional> professionalList = new ArrayList<>();
        List<ProfessionalHasServices> phsList;
        Professional professional;
        for (Services s :servicesList){
            phsList = phsRepo.getPHSsByServiceID(s.getIdServices());
            for(ProfessionalHasServices phs : phsList){
                professional = phs.getProfessional();
                if(! professionalList.contains(professional)) professionalList.add(professional);
            }
        }
        if(professionalList.size() == 0) throw new Exception();
        return professionalList;
    }

    @Override
    public List<Services> getServicesByProfessional(int professionalId) throws Exception {
        List<ProfessionalHasServices> phsList = phsRepo.getPHSsByProfessionalID(professionalId);
        List<Services> servicesList = new ArrayList<>();
        for(ProfessionalHasServices phs : phsList){
            servicesList.add(phs.getServices());
        }
        if(servicesList.size() == 0) throw new Exception();
        return servicesList;
    }

    @Override
    public Professional getProfessionalByEmail(String email) throws Exception {
        Professional professional = professionalRepository.getProfessionalByEmail(email);
        return professional;
    }

    @Override
    public List<Professional> getProfessionalsByState(int state) throws Exception {
        List<Professional> professionalList = professionalRepository.getProfessionalsByState(state);
        if(professionalList.isEmpty())throw new Exception();
        return professionalList;
    }

    @Override
    public Professional getProfessionalState(int professionalID) throws Exception {
        Professional pro = professionalRepository.getProfessionalByID(professionalID);
        if(pro == null) throw new Exception();
        return pro;
    }

    @Override
    public void updateProfessional(Professional p) throws Exception {
        professionalRepository.saveAndFlush(p);
    }

    @Override
    public void addProfessional(Professional p) throws Exception{
        professionalRepository.saveAndFlush(p);
    }
}
