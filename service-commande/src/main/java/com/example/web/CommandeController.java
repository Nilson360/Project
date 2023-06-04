package com.example.web;

import com.example.domain.Commande;
import com.example.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")

public class CommandeController {
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> getAllOrders() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getOrderById(@PathVariable Long id) {
        Commande order = commandeService.getCommandeById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Commande> createOrder(@RequestBody Commande commande) {
        Commande creerCommande = commandeService.creerCommande(commande);
        return new ResponseEntity<>(creerCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Commande updatedCommande = commandeService.updateCommande(id, commande);

      //  boolean updatedCommande = false;
       // boolean updatedCommande;

        if (updatedCommande == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
