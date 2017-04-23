package edu.eci.cosw.service;

import edu.eci.cosw.Interfaz.ClientManagement;
import edu.eci.cosw.Interfaz.repositorio.ClientRepository;
import edu.eci.cosw.models.Client;
import edu.eci.cosw.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oscar on 22/04/17.
 */
@Service
public class ClientsServiceImpl implements ClientManagement{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() throws Exception {
        List<Client> clientList = clientRepository.findAll();
        if(clientList.isEmpty())throw new Exception();
        return null;
    }

    @Override
    public Client getClientByEmail(String email) throws Exception {
        Client client = clientRepository.getClientByEmail(email);
        if(client == null) throw new Exception();
        return null;
    }
}
