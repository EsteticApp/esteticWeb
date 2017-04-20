package edu.eci.cosw.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import edu.eci.cosw.Interfaz.ServiceManagement;
import edu.eci.cosw.Interfaz.repositorio.ServicesRepository;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;

/**
 * Created by estudiante on 4/20/17.
 */

public class ServiciesServiceImpl implements ServiceManagement{

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<Services> getServicios() throws Exception{

        List<Services> services = servicesRepository.findAll();

        return services;
    }

    @Override
    public void addServicio(Services s) throws Exception{

    }
}
