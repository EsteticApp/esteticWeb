package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Servicio;

import java.util.List;

/**
 * Created by 2094687 on 2/20/17.
 */
public interface CategoryManagement {
    public List<String> getCategoriesName() throws Exception;
    public List<Services> getServicesByCategory(String category) throws Exception;
}
