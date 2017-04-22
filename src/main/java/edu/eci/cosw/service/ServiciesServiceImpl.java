package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.repositorio.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Services> getServicios() throws Exception {
        List<Services> services = servicesRepository.findAll();
        if(services.isEmpty())throw new Exception();
        return services;
    }

    @Override
    public void addServicio(Categories c) throws Exception {
        // Se debe obtener la Categoría de la BD para que exista una referencia y luego poder agregarle el servicio, ver la prubea de unidad addServiceTest()
        categoryRepository.saveAndFlush(c);
    }
}
