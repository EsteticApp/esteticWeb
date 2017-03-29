package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.UsuarioServicioOperaciones;
import edu.eci.cosw.models.Usuario;
import edu.eci.cosw.models.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 29/03/2017.
 */
@Service
public class UsuarioServicioStub implements UsuarioServicioOperaciones {

    private List<UsuarioServicio> precios;
    private User user;
    private Usuario usuario;

    public UsuarioServicioStub(){
        user = new User();
        usuario = user.getUserByEmail("profesional@mail.com");
        precios = new ArrayList<>();
        precios.add(new UsuarioServicio(1, 1, "10000"));
        precios.add(new UsuarioServicio(3, 4, "50000"));
        precios.add(new UsuarioServicio(2, 7, "7000"));
    }

    @Override
    public List<UsuarioServicio> getPrecios() {
        return precios;
    }
    @Override
    public String getPrecioServicios(int iduser, int idservicio){

        String precio = new String();
        for (UsuarioServicio us : precios){
            if (iduser == us.getUsers_iduser() && idservicio == us.getServices_idServices()) {
                precio = us.getPrice();
                break;
            }
        }
        return precio;
    }


    @Override
    public void addPrecioServicio(String price){

    }
}
