package com.example.genius.service;

import com.example.genius.dataBase.PanierItemsRepository;
import com.example.genius.dataBase.PanierRepository;
import com.example.genius.domain.Panier;
import com.example.genius.genius.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService extends IntegrationProperties.RSocket.Client {
    private final PanierRepository panierRepository;
    private final PanierItemsRepository panierItemsRepository;
    private final WebClient webClient;

    @Autowired
    public PanierService(PanierRepository panierRepository, PanierItemsRepository panierItemsRepository, WebClient webClient) {
        this.panierRepository = panierRepository;
        this.panierItemsRepository = panierItemsRepository;
        this.webClient = webClient;
    }


    /**
     * L'api
     */
    // Récupère les informations du produit dans le panier
    public Mono<Product> getProductInPanier(Long panierId) {
        return this.webClient.get()
                .uri("http://localhost:8082/products/paniers/" + panierId)
                .retrieve()
                .bodyToMono(Product.class);
    }
    /**
     * Méthodes de la classe
     *
     * @return
     */
    // Récupère tous les paniers
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    // Crée un nouveau panier
    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    // Met à jour un panier existant
    public Panier updatePanier(Long id, Panier updatedPanier) {
        Optional<Panier> existingPanier = panierRepository.findById(id);
        if (existingPanier.isPresent()) {
            Panier panier = existingPanier.get();
            panier.setdClient(updatedPanier.getClientId());
            panier.setCreationDate(updatedPanier.getCreationDate());

            // Mettre à jour les autres champs si nécessaire

            return panierRepository.save(panier); // Renvoie le panier mis à jour
        } else {
            return null; // Aucun panier trouvé avec l'identifiant donné
        }
    }

    // Supprime un panier
    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }

    // Récupère un panier par son identifiant
    public Panier getPanierById(Long id) {
        Optional<Panier> panier = panierRepository.findById(id);
        return panier.orElse(null); // Renvoie le panier s'il existe, sinon renvoie null
    }
}
