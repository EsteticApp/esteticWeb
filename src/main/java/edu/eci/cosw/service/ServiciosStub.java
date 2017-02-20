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

    private static List<Servicio> servicios;

    public ServiciosStub(){
        servicios = new ArrayList<>();
        Servicio ser = new Servicio("Cortes");servicios.add(ser);
        ser = new Servicio("Tintes");servicios.add(ser);
        ser = new Servicio("Cepillado");servicios.add(ser);
        ser = new Servicio("Mechas");servicios.add(ser);
        ser = new Servicio("Extensiones");servicios.add(ser);
        ser = new Servicio("Recogidos");servicios.add(ser);
        ser = new Servicio("Manicure");servicios.add(ser);
        ser = new Servicio("Pedicure");servicios.add(ser);
        ser = new Servicio("Esmaltado permanente");servicios.add(ser);
        ser = new Servicio("Decoración");servicios.add(ser);
        ser = new Servicio("Tradicional");servicios.add(ser);
        ser = new Servicio("Roll-on");servicios.add(ser);
        ser = new Servicio("Depilación");servicios.add(ser);
        ser = new Servicio("Oriental con ventosas");servicios.add(ser);
        ser = new Servicio("Hot stones");servicios.add(ser);
        ser = new Servicio("Tuina");servicios.add(ser);
        ser = new Servicio("Tailandés");servicios.add(ser);
        ser = new Servicio("Circulatorio");servicios.add(ser);
        ser = new Servicio("Anticelulítico");servicios.add(ser);
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
