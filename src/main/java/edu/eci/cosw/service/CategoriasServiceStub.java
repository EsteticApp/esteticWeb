package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.CategoryManagement;
import edu.eci.cosw.Interfaz.ServicioOperaciones;
import edu.eci.cosw.models.Categoria;
import edu.eci.cosw.models.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Creación de categorias con datos quemados
 * @author Deivan OLiva
 */

@Service
public class CategoriasServiceStub implements CategoryManagement{

    private List<Categoria> categorias;
    private List<Servicio> serviciosFilter;

    public CategoriasServiceStub(){
        fillCategories();
    }

    public List<String> getCategoriesName() throws Exception {
        if(categorias == null)fillCategories();
        List<String> lista = new ArrayList<String>();
        for (Categoria c : categorias){
            lista.add(c.getName());
        }
        if(lista.isEmpty())throw new Exception();
        return lista;
    }

    public List<Servicio> getServicesByCategory(String category) throws Exception {
        if(categorias == null)fillCategories();
        List<Servicio> services = new ArrayList<>();
        for(Categoria cat : categorias){
            if(cat.getName().equals(category))services = cat.getServices();
        }
        if(services.isEmpty()) throw new Exception();
        return services;
    }

    private void fillCategories(){
        categorias = new ArrayList<>();
        Categoria cat = new Categoria("Peluquería");
        Servicio ser = new Servicio("Cortes");cat.addService(ser);
        ser = new Servicio("Tintes");cat.addService(ser);
        ser = new Servicio("Cepillado");cat.addService(ser);
        ser = new Servicio("Mechas");cat.addService(ser);
        ser = new Servicio("Extensiones");cat.addService(ser);
        ser = new Servicio("Recogidos");cat.addService(ser);
        categorias.add(cat);

        cat = new Categoria("Uñas");
        ser = new Servicio("Manicure");cat.addService(ser);
        ser = new Servicio("Pedicure");cat.addService(ser);
        ser = new Servicio("Esmaltado permanente");cat.addService(ser);
        ser = new Servicio("Decoración");cat.addService(ser);
        categorias.add(cat);

        cat = new Categoria("Depilación");
        ser = new Servicio("Tradicional");cat.addService(ser);
        ser = new Servicio("Roll-on");cat.addService(ser);
        ser = new Servicio("Egipcia");cat.addService(ser);
        categorias.add(cat);

        cat = new Categoria("Masajes");
        ser = new Servicio("Oriental con ventosas");cat.addService(ser);
        ser = new Servicio("Hot stones");cat.addService(ser);
        ser = new Servicio("Tuina");cat.addService(ser);
        ser = new Servicio("Tailandés");cat.addService(ser);
        ser = new Servicio("Circulatorio");cat.addService(ser);
        ser = new Servicio("Anticelulítico");cat.addService(ser);
        categorias.add(cat);
    }
}