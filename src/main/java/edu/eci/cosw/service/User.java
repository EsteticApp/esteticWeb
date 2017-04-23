/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.eci.cosw.service;
import edu.eci.cosw.Interfaz.UserApp;
import edu.eci.cosw.models.Client;
import edu.eci.cosw.models.Professional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class User implements UserApp{

    private static List<edu.eci.cosw.Interfaz.User> users;

    /**
     * Estos solo los uso para pruebas mientras se termina login BD
     */

    static {
        users = new ArrayList();
        
        
        users.add(new Client("Cliente prueba","cliente@mail.com", "cliente",null));
        
        users.add(new Professional("Profesional prueba","0","profesional@mail.com", "profesional", "CLIENTE",null,0));
    }

/*
    static {
        users = new ArrayList();
        Role rolUser =new Role("CLIENTE","Persona que compraran el servicio");
        // Usuarios y contrasenas - quemado en codigo
        users.add(new User("Marcela Duque",0, "marceduque@mail.com", "Marcela123", rolUser));
        users.add(new User("Alejandro Durán",0, "durancho@mail.com", "Alejandro123", rolUser));
        users.add(new User("Fabián Pérez",0, "fapez@mail.com", "Fabian123", rolUser));
        users.add(new User("Yuli Paola ",0, "paopao@mail.com", "Yuli123", rolUser));
        users.add(new User("Iván Gómez",0, "gomeziv@mail.com", "Ivan123", rolUser));
        
        rolUser = new Role("PROFESSIONAL","personas que ofrecen el servicio");        
        users.add(new User("Ximena Guerrero",67157431, "ximenis@mail.com", "Ximena123", rolUser));
        users.add(new User("Luis Fernandez",19405067, "luchofe@mail.com", "Luis123", rolUser));
        users.add(new User("Juliana Casta",38117674, "julica@mail.com", "Juliana123", rolUser));
        users.add(new User("Sandra Izquierdo",19392904, "sandraz@mail.com", "Sandra123", rolUser));
        users.add(new User("Roberto Lopez",70651124, "robert45@mail.com", "Roberto123", rolUser));
        */

    
    public User(){}

    @Override
    public List<edu.eci.cosw.Interfaz.User> getUsers() {
        return users;
    }

    @Override
    public void addUser(edu.eci.cosw.Interfaz.User user) {
        users.add(user);
    }

    @Override
    public List<edu.eci.cosw.Interfaz.User> getSimpleUsers() {
        ArrayList<edu.eci.cosw.Interfaz.User> simpleUsers = new ArrayList<>();
        Professional user;
        for(edu.eci.cosw.Interfaz.User usr : users){
            user = new Professional();
            user.setName(usr.getName());
            user.setEmail(usr.getEmail());
            user.setRole(usr.getRole());
            simpleUsers.add(user);
        }
        return simpleUsers;
    }

    @Override
    public edu.eci.cosw.Interfaz.User getUserByUsername(String username) {
        edu.eci.cosw.Interfaz.User response = null;
        for (edu.eci.cosw.Interfaz.User user : users) {
            if (user.getName().equals(username)) {
                response = user;
                break;
            }
        }
        return response;
    }

    @Override
    public edu.eci.cosw.Interfaz.User getUserByEmail(String email) {
        edu.eci.cosw.Interfaz.User response = null;
        for (edu.eci.cosw.Interfaz.User user : users) {
            if (user.getEmail().equals(email)) {
                response = user;
                break;
            }
        }
        return response;
    }

    @Override
    public edu.eci.cosw.Interfaz.User loginUser(String name, String pass) {
        edu.eci.cosw.Interfaz.User response = null;
        for (edu.eci.cosw.Interfaz.User user : users) {
            if ((user.getName().equals(name) || user.getEmail().equals(name)) && user.getPassword().equals(pass)) {
                response = user;
                break;
            }
        }
        return response;
    }

}
