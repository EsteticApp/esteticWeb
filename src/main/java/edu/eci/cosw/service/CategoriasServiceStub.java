package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Services;
import java.util.ArrayList;
import java.util.List;

/**
 * Creación de categorias con datos quemados
 * @author Deivan OLiva
 */
public class CategoriasServiceStub implements CategoryManagement{

    private List<Categories> categorias;
    private List<Services> serviciosFilter;

    public CategoriasServiceStub(){
        fillCategories();
    }

    public List<Categories> getCategoriesName() throws Exception {
        if(categorias == null)fillCategories();
        List<String> lista = new ArrayList<>();
        if(categorias.isEmpty())throw new Exception();
        return categorias;
    }

    public List<Services> getServicesByCategory(String category) throws Exception {
        if(categorias == null)fillCategories();
        List<Services> services = new ArrayList<>();
        for(Categories cat : categorias){
            if(cat.getName().equals(category)){
                for (Services s : cat.getServices()){
                    services.add(s);
                }
            }
        }
        if(services.isEmpty()) throw new Exception();
        return services;
    }

    private void fillCategories(){
        categorias = new ArrayList<>();
        Categories cat = new Categories("Peluqueria");
        Services ser = new Services("Cortes");cat.getServices().add(ser);
        ser = new Services("Tintes");cat.getServices().add(ser);
        ser = new Services("Cepillado");cat.getServices().add(ser);
        ser = new Services("Mechas");cat.getServices().add(ser);
        ser = new Services("Extensiones");cat.getServices().add(ser);
        ser = new Services("Recogidos");cat.getServices().add(ser);
        categorias.add(cat);

        cat = new Categories("Unas");
        ser = new Services("Manicure");cat.getServices().add(ser);
        ser = new Services("Pedicure");cat.getServices().add(ser);
        ser = new Services("Esmaltado permanente");cat.getServices().add(ser);
        ser = new Services("Decoración");cat.getServices().add(ser);
        categorias.add(cat);

        cat = new Categories("Depilacion");
        ser = new Services("Tradicional");cat.getServices().add(ser);
        ser = new Services("Roll-on");cat.getServices().add(ser);
        ser = new Services("Egipcia");cat.getServices().add(ser);
        categorias.add(cat);

        cat = new Categories("Masajes");
        ser = new Services("Oriental con ventosas");cat.getServices().add(ser);
        ser = new Services("Hot stones");cat.getServices().add(ser);
        ser = new Services("Tuina");cat.getServices().add(ser);
        ser = new Services("Tailandés");cat.getServices().add(ser);
        ser = new Services("Circulatorio");cat.getServices().add(ser);
        ser = new Services("Anticelulítico");cat.getServices().add(ser);
        categorias.add(cat);
    }
}