package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.ProfessionalHasServices;

import java.util.List;

/**
 * Created by SYSTEM on 2/20/17.
 */
public interface ProfessionalHasServiceManagement {

    public List<ProfessionalHasServices> getPHSs() throws Exception;
    public ProfessionalHasServices getSpecificPHS(int idPro, int idSer) throws Exception;

//    public List<UsuarioServicio> getPrecios(int iduser, int idservicio);
//    public String getPrecioServicios(int iduser, int idservicio);
//    public void addPrecioServicio(String price);
}
