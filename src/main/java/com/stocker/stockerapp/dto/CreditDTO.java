package com.stocker.stockerapp.dto;


import com.stocker.stockerapp.entities.Client;
import com.stocker.stockerapp.entities.Fournisseur;

import java.time.LocalDateTime;

public class CreditDTO {
    private Long id;

    private Double amount;

    private LocalDateTime date;
    private Boolean isPaid;

    private Client client;

    private Fournisseur fournisseur;

    public CreditDTO(Long id,Double amount, LocalDateTime date, Client client, Fournisseur fournisseur, Boolean isPaid) {
        this.id=id;
        this.amount = amount;
        this.date = date;
        this.client = client;
        this.fournisseur = fournisseur;
        this.isPaid = isPaid;
    }

    public CreditDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}