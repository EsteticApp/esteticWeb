package edu.eci.cosw.Interfaz;

import edu.eci.cosw.models.Categories;
import edu.eci.cosw.models.Client;
import edu.eci.cosw.models.Services;

import java.util.List;

/**
 * Created by oscar on 22/04/17.
 */
public interface ClientManagement {
    public List<Client> getClients() throws Exception;
    public Client getClientByEmail(String email) throws Exception;
    public Client getClientByID(int clientID) throws Exception;
}
