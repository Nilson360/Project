package web;

import domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")

public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Récuperer tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Récuperer un client par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client); // Renvoie le client avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Créer un nouveau client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Mettre à jour un client existant
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Client client = clientService.updateClient(id, updatedClient);
        if (client != null) {
            return ResponseEntity.ok(client); // Renvoie le client mis à jour avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build(); // Renvoie une réponse sans contenu avec le code de réponse No Content (204)
    }
}
