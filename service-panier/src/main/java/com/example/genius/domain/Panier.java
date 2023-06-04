package com.example.genius.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Panier")

public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idClient")
    private Long clientId;

    @Column(name = "dateCreation")
    private Date creationDate;

    @OneToMany(mappedBy = "idPanier")
    private List<PanierItem> panierItems;

    // Méthodes get et set :
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<PanierItem> getPanierItems() {
        return panierItems;
    }

    public void setCartItems(List<PanierItem> panierItems) {
        this.panierItems = panierItems;
    }

    public void setdClient(Long clientId) {
    }
}
