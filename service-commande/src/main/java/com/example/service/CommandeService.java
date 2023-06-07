package com.example.service;

import ch.qos.logback.core.net.server.Client;
import com.example.dataBase.CommandeItemRepository;
import com.example.dataBase.CommandeRepository;
import com.example.domain.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final CommandeItemRepository commandeItemRepository;
    private final WebClient webClient;  // Ajout de WebClient

    @Autowired
    public CommandeService(CommandeRepository commandeRepository,
                           CommandeItemRepository commandeItemRepository,
                           WebClient webClient) {  // Ajout de WebClient dans le constructeur
        this.commandeRepository = commandeRepository;
        this.commandeItemRepository = commandeItemRepository;
        this.webClient = webClient;  // Initialisation de WebClient
    }

    /**
     *  API GETWAY
     * @param id
     * @return
     */
    // Méthode pour obtenir des informations sur le client à partir du service Client
    public Mono<Client> getClientById(Long id) {
        return this.webClient.get()  // Crée une requête GET
                .uri("http://localhost:8080/client/" + id)  // Ajoute l'URI du service Client
                .retrieve()  // Récupère la réponse
                .bodyToMono(Client.class);  // Convertit le corps de la réponse en objet Client
    }

    // Récupère les détails du produit à partir du service Produit
    /*
    public Mono<Product> getProductById(Long id) {
        return this.webClient.get()
                .uri("http://localhost:8080/products/" + id)
                .retrieve()
                .bodyToMono(Product.class);
    }
*/
    /**
     * Méthodes de la classe
     *
     * @return
     */
    // Récupère toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Récupère une commande par son identifiant
    public Commande getCommandeById(Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        return commande.orElse(null);
    }

    // Crée une nouvelle commande
    public Commande creerCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Met à jour une commande existante
    public Commande updateCommande(Long id, Commande updatedCommande) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        if (optionalCommande.isPresent()) {
            Commande existingCommande = optionalCommande.get();

            // Mise à jour des champs de commande existants
            existingCommande.setStatut(updatedCommande.getStatut());
            // Mise à jour des autres champs de commande si nécessaire

            return commandeRepository.save(existingCommande); // Renvoie la commande mise à jour
        } else {
            return null; // Aucune commande trouvée avec l'identifiant donné
        }
    }

    // Supprime une commande
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
