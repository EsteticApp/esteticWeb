package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ProfessionalHasServiceManagement;
import edu.eci.cosw.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 29/03/2017.
 */
public class UsuarioServicioStub implements ProfessionalHasServiceManagement {

    private List<ProfessionalHasServices> precios;

    public UsuarioServicioStub(){
        precios = new ArrayList<>();
        ProfessionalHasServices phs = new ProfessionalHasServices();
        ProfessionalHasServicesId phsID = new ProfessionalHasServicesId();
        Professional professional;
        Services service;

        // 1
        phsID.setIdProfessional(1);phsID.setIdServices(1);
        professional = new Professional("Profesional 1","123","profesional1@mail.com","1234", "PROFESSIONAL", null,0);
        service = new Services("Corte");
        phs.setId(phsID);
        phs.setPrice("10000");
        phs.setProfessional(professional);
        phs.setServices(service);
        precios.add(phs);
        // 2
        phs = new ProfessionalHasServices();
        phsID = new ProfessionalHasServicesId();
        phsID.setIdProfessional(3);phsID.setIdServices(4);
        professional = new Professional("Profesional 3","123","profesional3@mail.com","1234", "PROFESSIONAL", null,0);
        service = new Services("Mechas");
        phs.setId(phsID);
        phs.setPrice("50000");
        phs.setProfessional(professional);
        phs.setServices(service);
        precios.add(phs);
        // 3
        phs = new ProfessionalHasServices();
        phsID = new ProfessionalHasServicesId();
        phsID.setIdProfessional(2);phsID.setIdServices(7);
        professional = new Professional("Profesional 2","123","profesional2@mail.com","1234", "PROFESSIONAL", null,0);
        service = new Services("Manicure");
        phs.setId(phsID);
        phs.setPrice("7000");
        phs.setProfessional(professional);
        phs.setServices(service);
        precios.add(phs);
    }

    @Override
    public List<ProfessionalHasServices> getPHSs() throws Exception{
        return precios;
    }

    @Override
    public ProfessionalHasServices getSpecificPHS(int idPro, int idSer) throws Exception{
        ProfessionalHasServices phs = null;
        for(ProfessionalHasServices p : precios){
            if(p.getId().getIdServices() == idSer && p.getId().getIdProfessional() == idPro){
                phs = p;
                break;
            }
        }
        if(phs == null) throw new Exception();
        return phs;
    }

    //    @Override
//    public List<UsuarioServicio> getPrecios(int iduser, int idservicio) {
//        List<UsuarioServicio> us = new ArrayList<>();
//        for (UsuarioServicio u : precios){
//            if(  (u.getUsers_iduser() == iduser)   && (u.getServices_idServices() == idservicio)   ){
//                us.add(u);
//            }
//        }
//        return us;
//    }
//
//    @Override
//    public String getPrecioServicios(int iduser, int idservicio){
//
//        String precio = new String();
//        for (UsuarioServicio us : precios){
//            if (iduser == us.getUsers_iduser() && idservicio == us.getServices_idServices()) {
//                precio = us.getPrice();
//                break;
//            }
//        }
//        return precio;
//    }
//
//
//    @Override
//    public void addPrecioServicio(String price){
//
//    }
}
