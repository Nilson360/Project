package com.example.genius.web;

import com.example.genius.domain.Panier;
import com.example.genius.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paniers")
public class PanierController {
    private final PanierService panierService;

    @Autowired
    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    // Récupère tous les paniers
    @GetMapping
    public List<Panier> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    // Récupère un panier par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Panier> getPanierById(@PathVariable Long id) {
        Panier panier = panierService.getPanierById(id);
        if (panier != null) {
            return ResponseEntity.ok(panier); // Renvoie le panier avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Crée un nouveau panier
    @PostMapping
    public Panier createPanier(@RequestBody Panier panier) {
        return panierService.createPanier(panier);
    }

    // Met à jour un panier existant
    @PutMapping("/{id}")
    public ResponseEntity<Panier> updatePanier(@PathVariable Long id, @RequestBody Panier updatedPanier) {
        Panier panier = panierService.updatePanier(id, updatedPanier);
        if (panier != null) {
            return ResponseEntity.ok(panier); // Renvoie le panier mis à jour avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Supprime un panier
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanier(@PathVariable Long id) {
        panierService.deletePanier(id);
        return ResponseEntity.noContent().build(); // Renvoie une réponse sans contenu avec le code de réponse No Content (204)
    }
}
