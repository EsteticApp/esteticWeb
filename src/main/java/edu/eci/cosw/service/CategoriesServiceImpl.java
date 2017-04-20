package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.Interfaz.repositorio.CategoryRepository;
import edu.eci.cosw.Interfaz.repositorio.ServicesRepository;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 19/04/17.
 */
@Service
public class CategoriesServiceImpl implements CategoryManagement {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<String> getCategoriesName() throws Exception {
        List<Categories> categories = categoryRepository.findAll();

        List<String> categoriesNames = new ArrayList<>();
        for(Categories cat : categories){
            categoriesNames.add(cat.getName());
        }
        if(categoriesNames.isEmpty())throw new Exception();
        return categoriesNames;
    }

    @Override
    public List<String> getServicesByCategory(String category) throws Exception {
        List<Services> services = servicesRepository.getServicesByCategory(category);
        List<String> servicesName = new ArrayList<>();
        for(Services serv : services){
            servicesName.add(serv.getName());
        }
        if(services.isEmpty())throw new Exception();
        return servicesName;
    }
}
