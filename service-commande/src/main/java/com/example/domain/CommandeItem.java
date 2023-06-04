package com.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CommandeItem")
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;

    @Column(name = "idProduit")
    private Long idprodut;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getIdprodut() {
        return idprodut;
    }

    public void setIdprodut(Long idprodut) {
        this.idprodut = idprodut;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
