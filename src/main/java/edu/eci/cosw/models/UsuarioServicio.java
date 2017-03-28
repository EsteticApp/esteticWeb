package edu.eci.cosw.models;

/**
 * Created by 2083990 on 3/28/17.
 */
public class UsuarioServicio {

    private String precio;

    public UsuarioServicio(){

    }

    public UsuarioServicio(String precio){
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
