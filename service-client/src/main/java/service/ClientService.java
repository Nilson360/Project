package service;

import dataBase.ClientRepository;
import domain.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
