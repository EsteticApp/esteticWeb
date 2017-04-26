package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.Interfaz.repositorio.CategoryRepository;
import edu.eci.cosw.Interfaz.repositorio.ServicesRepository;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<Categories> getCategories() throws Exception {
        List<Categories> categories = categoryRepository.findAll();
        if(categories.isEmpty())throw new Exception();
        return categories;
    }

    @Override
    public List<Services> getServicesByCategory(int category) throws Exception {
        List<Services> services = servicesRepository.getServicesByCategory(category);
        if(services.isEmpty())throw new Exception();
        return services;
    }
}
