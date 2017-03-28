package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.EstilistaOperaciones;
import edu.eci.cosw.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class EstilistasServiceStub implements EstilistaOperaciones{

    private List<Estilista> estilistas;
    @Autowired
    private Usuario user;

    //prueba
    private static List<Usuario> users;

    @Override
    public List<Servicio> getServicesByStylist(String stylist) throws Exception{
        if(estilistas == null) fillStylist();
        List<Servicio> servicies = new ArrayList<>();
        Usuario su;
        for(Estilista sty : estilistas){
            su = (Usuario) sty.getRolEstilista();
            if(su.getName().equals(stylist)){
                servicies = sty.getAllServicies();
                break;
            }
        }
        if(servicies.isEmpty())throw new Exception();
        return servicies;
    }

    @Override
    public List<Estilista> getEstilistas() throws Exception{
        if(estilistas == null)fillStylist();
        if(estilistas.isEmpty())throw new Exception();
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

        if(e.getRolEstilista().getRoles_idRole().getNombre().equals("PROFESSIONAL")){
            estilistas.add(e);
        }

    }

    private void fillStylist(){
        estilistas = new ArrayList<>();

//        List<Usuario> users = user.getSimpleUsers();
//        for(Usuario usr : users){
//            if(usr.getRole().getNombre().equals("PROFESSIONAL")){
//                estilistas.add(new Estilista(usr));
//            }
//        }

        //prueba desde acá
        //users = new ArrayList();
        //Role rolUser =new Role("CLIENTE","Persona que compraran el servicio");
        //users.add(new Usuario("Cliente prueba","0","cliente@mail.com", "cliente", rolUser,null,0));

        //estilistas.add(new Estilista(users.get(0)));
        //prueba hasta acá

        //Primer estilísta
        Categoria category = new Categoria("Peluqueria");
        Servicio serv = new Servicio("Cepillado");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Peluqueria");
        serv = new Servicio("Cortes");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Peluqueria");
        serv = new Servicio("Tintes");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Unas");
        serv = new Servicio("Manicure");
        category.addService(serv);
        estilistas.get(0).addCategory(category);

        category = new Categoria("Depilacion");
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


        category = new Categoria("Unas");
        serv = new Servicio("Decoración");
        category.addService(serv);
        estilistas.get(1).addCategory(category);

        category = new Categoria("Depilacion");
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

        category = new Categoria("Unas");
        serv = new Servicio("Esmaltado permanente");
        category.addService(serv);
        estilistas.get(2).addCategory(category);

        category = new Categoria("Depilacion");
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

        category = new Categoria("Unas");
        serv = new Servicio("Manicure");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        category = new Categoria("Unas");
        serv = new Servicio("Pedicure");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        category = new Categoria("Depilacion");
        serv = new Servicio("Tradicional");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Anticelulítico");
        category.addService(serv);
        estilistas.get(3).addCategory(category);

        //Quinto estilísta
        /*category = new Categoria("Peluquería");
        serv = new Servicio("Tintes");
        category.addService(serv);
        estilistas.get(4).addCategory(category);*/

        category = new Categoria("Unas");
        serv = new Servicio("Manicure");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Unas");
        serv = new Servicio("Pedicure");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Depilacion");
        serv = new Servicio("Tradicional");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Depilacion");
        serv = new Servicio("Egipcia");
        category.addService(serv);
        estilistas.get(4).addCategory(category);

        category = new Categoria("Masajes");
        serv = new Servicio("Circulatorio");
        category.addService(serv);
        estilistas.get(4).addCategory(category);
    }
}
