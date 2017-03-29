package edu.eci.cosw.models;

/**
 * Created by 2083990 on 3/28/17.
 */
public class UsuarioServicio {

    private int Users_iduser;
    private int Services_idServices;
    private String price;
    //
    //

    public UsuarioServicio(int iduser, int idservicio, String precio){

        Users_iduser = iduser;
        Services_idServices = idservicio;
        price = precio;

    }

    public UsuarioServicio(String price){
        this.price = price;
    }

    public int getUsers_iduser() {
        return Users_iduser;
    }

    public void setUsers_iduser(int users_iduser) {
        Users_iduser = users_iduser;
    }

    public int getServices_idServices() {
        return Services_idServices;
    }

    public void setServices_idServices(int services_idServices) {
        Services_idServices = services_idServices;
    }

    public String getPrecio() {
        return price;
    }

    public void setPrecio(String precio) {
        this.price = price;
    }
}
