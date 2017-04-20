package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ServiceManagement;
import edu.eci.cosw.models.Services;
import edu.eci.cosw.models.Servicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 19/02/2017.
 */
@Service
public class ServiciosStub implements ServiceManagement{

    private static List<Services> servicios;

    public ServiciosStub(){
        servicios = new ArrayList<>();
        Services ser = new Services("Cortes");servicios.add(ser);
        ser = new Services("Tintes");servicios.add(ser);
        ser = new Services("Cepillado");servicios.add(ser);
        ser = new Services("Mechas");servicios.add(ser);
        ser = new Services("Extensiones");servicios.add(ser);
        ser = new Services("Recogidos");servicios.add(ser);
        ser = new Services("Manicure");servicios.add(ser);
        ser = new Services("Pedicure");servicios.add(ser);
        ser = new Services("Esmaltado permanente");servicios.add(ser);
        ser = new Services("Decoración");servicios.add(ser);
        ser = new Services("Tradicional");servicios.add(ser);
        ser = new Services("Roll-on");servicios.add(ser);
        ser = new Services("Depilación");servicios.add(ser);
        ser = new Services("Oriental con ventosas");servicios.add(ser);
        ser = new Services("Hot stones");servicios.add(ser);
        ser = new Services("Tuina");servicios.add(ser);
        ser = new Services("Tailandés");servicios.add(ser);
        ser = new Services("Circulatorio");servicios.add(ser);
        ser = new Services("Anticelulítico");servicios.add(ser);
    }

    @Override
    public List<Services> getServicios() {
        return servicios;
    }

    @Override
    public void addServicio(Services s) {
        servicios.add(s);
    }

}
