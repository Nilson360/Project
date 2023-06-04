package com.example.genius.domain;

import javax.persistence.*;

@Entity
@Table(name = "PanierItem")

public class PanierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;

    @Column(name = "idProduit")
    private Long productId;

    private Integer quantite;
}
