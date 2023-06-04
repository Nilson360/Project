package com.example.genius.web;

import com.example.genius.domain.Panier;
import com.example.genius.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PanierController {
    private final PanierService panierService;

    @Autowired
    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping
    public List<Panier> getAllPanier() {
        return panierService.getAllPanier();
    }

}
