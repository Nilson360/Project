package com.example.genius.service;

import com.example.genius.dataBase.PanierItemsRepository;
import com.example.genius.dataBase.PanierRepository;
import com.example.genius.domain.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierService {
    private final PanierRepository panierRepository;
    private final PanierItemsRepository panierItemsRepository;

    @Autowired
    public PanierService(PanierRepository panierRepository, PanierItemsRepository panierItemsRepository) {
        this.panierRepository = panierRepository;
        this.panierItemsRepository = panierItemsRepository;
    }

    public List<Panier> getAllPanier() {
        return panierRepository.findAll();
    }
}
