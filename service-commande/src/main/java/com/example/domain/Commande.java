package com.example.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Commande")

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idClient")
    private Long idclient;

    @Column(name = "dateCommande")
    private Date dateCommande;

    private String statut;

    @OneToMany(mappedBy = "Commande")
    private List<CommandeItem> commandeItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdclient() {
        return idclient;
    }

    public void setIdclient(Long idclient) {
        this.idclient = idclient;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }
}
