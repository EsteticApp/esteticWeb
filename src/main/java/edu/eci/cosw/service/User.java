/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.eci.cosw.service;
import edu.eci.cosw.models.Usuario;


import edu.eci.cosw.Interfaz.UserApp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.eci.cosw.Interfaz.UserApp;
import edu.eci.cosw.models.Role;
/**
 *
 * @author ANDRES CAICEDO
 */
@Service
public class User implements UserApp{

    private static List<Usuario> users;
/*
    static {
        users = new ArrayList();
        Role rolUser =new Role("CLIENTE","Persona que compraran el servicio");
        // Usuarios y contrasenas - quemado en codigo
        users.add(new Usuario("Marcela Duque",0, "marceduque@mail.com", "Marcela123", rolUser));
        users.add(new Usuario("Alejandro Durán",0, "durancho@mail.com", "Alejandro123", rolUser));
        users.add(new Usuario("Fabián Pérez",0, "fapez@mail.com", "Fabian123", rolUser));
        users.add(new Usuario("Yuli Paola ",0, "paopao@mail.com", "Yuli123", rolUser));
        users.add(new Usuario("Iván Gómez",0, "gomeziv@mail.com", "Ivan123", rolUser));
        
        rolUser = new Role("PROFESSIONAL","personas que ofrecen el servicio");        
        users.add(new Usuario("Ximena Guerrero",67157431, "ximenis@mail.com", "Ximena123", rolUser));
        users.add(new Usuario("Luis Fernandez",19405067, "luchofe@mail.com", "Luis123", rolUser));
        users.add(new Usuario("Juliana Casta",38117674, "julica@mail.com", "Juliana123", rolUser));
        users.add(new Usuario("Sandra Izquierdo",19392904, "sandraz@mail.com", "Sandra123", rolUser));
        users.add(new Usuario("Roberto Lopez",70651124, "robert45@mail.com", "Roberto123", rolUser));
        */

    
    public User(){}

    @Override
    public List<Usuario> getUsers() {
        return users;
    }

    @Override
    public void addUser(Usuario user) {
        users.add(user);
    }

    @Override
    public List<Usuario> getSimpleUsers() {
        ArrayList<Usuario> simpleUsers = new ArrayList<>();
        Usuario user;
        for(Usuario usr : users){
            user = new Usuario();
            user.setNombre(usr.getNombre());
            user.setEmail(usr.getEmail());
            user.setRole(usr.getRole());
            simpleUsers.add(user);
        }
        return simpleUsers;
    }

    @Override
    public Usuario getUserByUsername(String username) {
        Usuario response = null;
        for (Usuario user : users) {
            if (user.getNombre().equals(username)) {
                response = user;
                break;
            }
        }
        return response;
    }

    @Override
    public Usuario getUserByEmail(String email) {
        Usuario response = null;
        for (Usuario user : users) {
            if (user.getEmail().equals(email)) {
                response = user;
                break;
            }
        }
        return response;
    }

    @Override
    public Usuario loginUser(String name, String pass) {
        Usuario response = null;
        for (Usuario user : users) {
            if ((user.getNombre().equals(name) || user.getEmail().equals(name)) && user.getPassword().equals(pass)) {
                response = user;
                break;
            }
        }
        return response;
    }

}
