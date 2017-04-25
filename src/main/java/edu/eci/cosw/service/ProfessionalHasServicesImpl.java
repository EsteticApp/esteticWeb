package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ProfessionalHasServiceManagement;
import edu.eci.cosw.Interfaz.repositorio.ProfessionalHasServicesRepository;
import edu.eci.cosw.models.ProfessionalHasServices;
import edu.eci.cosw.models.ProfessionalHasServicesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oscar on 22/04/17.
 */
@Service
public class ProfessionalHasServicesImpl implements ProfessionalHasServiceManagement{

    @Autowired
    private ProfessionalHasServicesRepository phsRepository;

    @Override
    public List<ProfessionalHasServices> getPHSs() throws Exception {
        List<ProfessionalHasServices> phsList = phsRepository.findAll();
        if(phsList.isEmpty())throw new Exception();
        return phsList;
    }

    @Override
    public ProfessionalHasServices getSpecificPHS(int idPro, int idSer) throws Exception {
        ProfessionalHasServices phs = null;
        ProfessionalHasServicesId phsID = new ProfessionalHasServicesId();
        phsID.setIdProfessional(idPro);
        phsID.setIdServices(idSer);
        phs = phsRepository.findOne(phsID);
        if(phs == null)throw new Exception();
        return phs;
    }
}
