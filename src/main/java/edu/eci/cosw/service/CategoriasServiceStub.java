package edu.eci.cosw.service;

import edu.eci.cosw.models.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Creación de categorias con datos quemados
 * @author Deivan OLiva
 */

@Service
public class CategoriasServiceStub {

    private List<Categoria> categorias = new ArrayList<Categoria>();

    public  CategoriasServiceStub(){

        categorias.add(new Categoria("Peluqueria"));
        categorias.add(new Categoria("Uñas"));
        categorias.add(new Categoria("Depilación"));
        categorias.add(new Categoria("Masajes"));
    }

    public List<String> getCategorias(){
        List<String> lista = new ArrayList<String>();
        for (Categoria c : categorias){
            lista.add(c.getNombre());
        }
        return lista;
        //return categorias;
    }



}
