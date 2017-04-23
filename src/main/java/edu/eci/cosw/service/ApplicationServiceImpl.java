/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.service;


import edu.eci.cosw.Interfaz.repositorio.ClientRepository;
import edu.eci.cosw.Interfaz.User;
import edu.eci.cosw.models.Client;
import edu.eci.cosw.models.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.cosw.Interfaz.repositorio.ProfessionalRepository;


/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ProfessionalRepository professionalRepo;
    @Autowired
    private ClientRepository clientRepo;
   
    
    @Override
    public User getUsuario(String email, String password) {

        User pro= professionalRepo.getProfessionalByEmail(email);
        if(pro==null){
            pro= clientRepo.getClientByEmail(email);
        }
        return pro;
    }

    @Override
    public void setUsuario(User user) {
        System.out.println(user.getRole());
        if(user.getRole().equals("PROFESSIONAL")){
            System.out.println("Esta en profesional");
            professionalRepo.save((Professional) user);
        }else{
            System.out.println("Esta en cliente");
            clientRepo.save((Client) user);
        }
        
    }

    @Override
    public User traerUsuario(String email) {
        User pro= professionalRepo.getProfessionalByEmail(email);
        if(pro==null){
            pro= clientRepo.getClientByEmail(email);
        }
        return pro;
    }
}