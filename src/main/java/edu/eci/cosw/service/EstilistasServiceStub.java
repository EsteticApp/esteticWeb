package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.models.*;
import edu.eci.cosw.models.Estilista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import edu.eci.cosw.Interfaz.UserApp;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class EstilistasServiceStub implements EstilistaOperaciones{

    private List<Estilista> estilistas;
    @Autowired
    private UserApp user;

    @Override
    public List<Servicio> getServicesByStylist(String stylist) throws Exception{
        if(estilistas == null) fillStylist();
        List<Servicio> servicies = new ArrayList<>();
        SimpleUsuario su;
        for(Estilista sty : estilistas){
            su = (SimpleUsuario) sty.getRolEstilista();
            if(su.getNombre().equals(stylist)){
                servicies = sty.getAllServicies();
                break;
            }
        }
        if(servicies.isEmpty())throw new Exception();
        return servicies;
    }

    @Override
    public List<Estilista> getEstilistas(){
        if(estilistas == null)fillStylist();
        return estilistas;
    }

    @Override
    public List<Estilista> getStylistsByCategory(String category) throws Exception{
        if(estilistas == null) fillStylist();
        List<Estilista> stylist = new ArrayList<>();
        for(Estilista sty : estilistas){
            for(Categoria cat : sty.getCategorias()){
                if(cat.getName().equals(category)){
                    stylist.add(sty);
                    break;
                }
            }
        }
        if(stylist.isEmpty())throw new Exception();
        return stylist;
    }

    @Override
    public void addEstilista(Estilista e) {

        if(e.getRolEstilista().equals("PROFESSIONAL")){
            estilistas.add(e);
        }

    }

    private void fillStylist(){
        estilistas = new ArrayList<>();
        List<SimpleUsuario> users = user.getSimpleUsers();

        for(SimpleUsuario usr : users){
            if(usr.getRole().equals("PROFESSIONAL")){
                estilistas.add(new Estilista(usr));
            }
        }

        //Primer estilísta
        Categoria category = new Categoria("Peluquería");
        Servicio serv = new Servicio("Cepillado");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Uñas");
        serv = new Servicio("Manicure");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Depilación");
        serv = new Servicio("Tradicional");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Tuina");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        //Segundo estilísta
        /*category = new Categoria("Peluquería");
        serv = new Servicio("Recogidos");
        category.addService(serv);
        estilistas.get(1).addCategory(category);*/

        category = new Categoria("Uñas");
        serv = new Servicio("Decoración");
        category.addService(serv);
        estilistas.get(1).addCategory(category);

        category = new Categoria("Depilación");
        serv = new Servicio("Egipcia");
        category.addService(serv);
        estilistas.get(1).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Hot stones");
        category.addService(serv);
        estilistas.get(1).addCategory(category);

        //Tercer estilísta
        /*category = new Categoria("Peluquería");
        serv = new Servicio("Cortes");
        category.addService(serv);
        estilistas.get(2).addCategory(category);*/

        category = new Categoria("Uñas");
        serv = new Servicio("Esmaltado permanente");
        category.addService(serv);
        estilistas.get(2).addCategory(category);

        category = new Categoria("Depilación");
        serv = new Servicio("Roll-on");
        category.addService(serv);
        estilistas.get(2).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Oriental con ventosas");
        category.addService(serv);
        estilistas.get(2).addCategory(category);

        //Cuarto estilísta
        /*category = new Categoria("Peluquería");
        serv = new Servicio("Extensiones");
        category.addService(serv);
        estilistas.get(3).addCategory(category);*/

        category = new Categoria("Uñas");
        serv = new Servicio("Pedicure");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        category = new Categoria("Depilación");
        serv = new Servicio("Tradicional");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Tuina");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        //Quinto estilísta
        /*category = new Categoria("Peluquería");
        serv = new Servicio("Tintes");
        category.addService(serv);
        estilistas.get(4).addCategory(category);*/

        category = new Categoria("Uñas");
        serv = new Servicio("Manicure");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Depilación");
        serv = new Servicio("Tradicional");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Tuina");
        category.addService(serv);
        estilistas.get(4).addCategory(category);
    }
}
