package edu.eci.cosw.models;

import edu.eci.cosw.Interfaz.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by estudiante on 2/16/17.
 */
public class Estilista{

    private Users rolEstilista;
    private List<Categoria> categorias;

    public Estilista(Users rolEstilista){
        this.rolEstilista = rolEstilista;
        this.categorias = new ArrayList<>();
    }

    public Users getRolEstilista(){

        return rolEstilista;
    }

    public void setRolEstilista(Usuario rolEstilista){

        this.rolEstilista = rolEstilista;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setServiceToCategory(Servicio service, String category){
        for(Categoria cat : categorias){
            if(cat.getName().equals(category)){
                cat.addService(service);
                break;
            }
        }
    }

    public List<Servicio> getServicesFromCategory(String category){
        List<Servicio> servicies = new ArrayList<>();
        for(Categoria cat : categorias){
            if(cat.getName().equals(category)){
                servicies = cat.getServices();
                break;
            }
        }
        return servicies;
    }

    public void addCategory(Categoria category){
        categorias.add(category);
    }

    public List<Servicio> getAllServicies(){
        List<Servicio> servicies = new ArrayList<>();
        for(Categoria cat : categorias){
            for(Servicio ser : cat.getServices()){
                servicies.add(ser);
            }
        }
        return servicies;
    }
}