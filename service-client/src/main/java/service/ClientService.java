package service;

import dataBase.ClientRepository;
import domain.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Récupère tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Récupère un client par son identifiant
    public Client getClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.orElse(null);
    }

    // Crée un nouveau client
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Met à jour un client existant
    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client existingClient = clientOptional.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setEmail(updatedClient.getEmail());

            // Mettre à jour d'autres propriétés si nécessaire

            return clientRepository.save(existingClient); // Renvoie le client mis à jour
        }
        return null; // Aucun client trouvé avec l'identifiant donné
    }

    // Supprime un client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
