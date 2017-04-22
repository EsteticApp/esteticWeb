package edu.eci.cosw.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by oscar on 19/04/17.
 */
@Embeddable
public class ProfessionalHasServicesId implements java.io.Serializable{

    private int idProfessional;
    private int idServices;

    public ProfessionalHasServicesId(){
    }

    @Column(name = "professional_idprofessional", nullable = false)
    public int getIdProfessional() {
        return idProfessional;
    }

    public void setIdProfessional(int idProfessional) {
        this.idProfessional = idProfessional;
    }

    @Column(name = "services_idservices", nullable = false)
    public int getIdServices() {
        return idServices;
    }

    public void setIdServices(int idServices) {
        this.idServices = idServices;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof ProfessionalHasServicesId))
            return false;
        ProfessionalHasServicesId castOther = (ProfessionalHasServicesId) other;

        return (this.getIdProfessional() == castOther
                .getIdProfessional())
                && (this.getIdServices() == castOther.getIdServices());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + this.getIdProfessional();
        result = 37 * result + this.getIdServices();
        return result;
    }
}
