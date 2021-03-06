package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;

import java.util.List;

/**
 * Created by 2094687 on 2/20/17.
 */
public interface CategoryManagement {
    public List<Categories> getCategories() throws Exception;
    public List<Services> getServicesByCategory(int categoryID) throws Exception;
}
