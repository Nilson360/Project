package com.example.service;

import com.example.dataBase.CommandeItemRepository;
import com.example.dataBase.CommandeRepository;
import com.example.domain.Commande;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeItemRepository commandeItemRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository, CommandeItemRepository commandeItemRepository) {
        this.commandeRepository = commandeRepository;
        this.commandeItemRepository = commandeItemRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        return commande.orElse(null);
    }

    public Commande creerCommande(Commande commande) {
        return commandeRepository.save(commande);

    }

    public Commande updateCommande(Long id, Commande updatedCommande) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        if (optionalCommande.isPresent()) {
            Commande existingCommande = optionalCommande.get();

            // mise à jour des commandes existentes
            existingCommande.setStatut(updatedCommande.getStatut());

            //  mise à jour des commandes si nécessaire
            return commandeRepository.save(existingCommande);
        } else {
            return null;
        }
    }
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
