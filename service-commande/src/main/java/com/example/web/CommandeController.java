package com.example.web;

import com.example.domain.Commande;
import com.example.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // Récupère toutes les commandes
    @GetMapping
    public List<Commande> getAllOrders() {
        return commandeService.getAllCommandes();
    }

    // Récupère une commande par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getOrderById(@PathVariable Long id) {
        Commande order = commandeService.getCommandeById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Renvoie une réponse Not Found (404)
        }
        return new ResponseEntity<>(order, HttpStatus.OK); // Renvoie la commande avec le code de réponse OK (200)
    }

    // Crée une nouvelle commande
    @PostMapping
    public ResponseEntity<Commande> createOrder(@RequestBody Commande commande) {
        Commande createdCommande = commandeService.creerCommande(commande);
        return new ResponseEntity<>(createdCommande, HttpStatus.CREATED); // Renvoie la commande créée avec le code de réponse Created (201)
    }

    // Met à jour une commande existante
    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Commande updatedCommande = commandeService.updateCommande(id, commande);
        if (updatedCommande == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Renvoie une réponse Not Found (404)
        }
        return new ResponseEntity<>(updatedCommande, HttpStatus.OK); // Renvoie la commande mise à jour avec le code de réponse OK (200)
    }

    // Supprime une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Renvoie une réponse sans contenu avec le code de réponse No Content (204)
    }
}
