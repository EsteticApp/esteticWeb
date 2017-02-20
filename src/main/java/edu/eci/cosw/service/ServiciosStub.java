package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ServicioOperaciones;
import edu.eci.cosw.models.Categoria;
import edu.eci.cosw.models.Servicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class ServiciosStub implements ServicioOperaciones{

    private static List<Servicio> servicios = new ArrayList<>();


    static{

        Categoria c = new Categoria("Peluqueria");
        servicios.add(new Servicio( "Cortes", c));
        servicios.add(new Servicio( "Tintes", c));
        servicios.add(new Servicio( "Cepillado", c));
        servicios.add(new Servicio( "Mechas", c));
        servicios.add(new Servicio( "Extensiones", c));
        servicios.add(new Servicio( "Recogidos", c));

        c = new Categoria("Uñas");
        servicios.add(new Servicio( "Manicure", c));
        servicios.add(new Servicio( "Pedicure", c));
        servicios.add(new Servicio( "Esmaltado permanente", c));
        servicios.add(new Servicio( "Decoración", c));

        c = new Categoria("Depilación");
        servicios.add(new Servicio( "Tradicional", c));
        servicios.add(new Servicio( "Roll-on", c));
        servicios.add(new Servicio( "Depilación", c));

        c = new Categoria("Masajes");
        servicios.add(new Servicio( "Oriental con ventosas", c));
        servicios.add(new Servicio( "Hot stones", c));
        servicios.add(new Servicio( "Tuina", c));
        servicios.add(new Servicio( "Tailandés", c));
        servicios.add(new Servicio( "Circulatorio", c));
        servicios.add(new Servicio( "Anticelulítico", c));

    }

    @Override
    public List<Servicio> getServicios() {
        return servicios;
    }

    @Override
    public void addServicio(Servicio s) {
        servicios.add(s);
    }


}
