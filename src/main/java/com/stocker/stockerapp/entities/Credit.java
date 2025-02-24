package com.stocker.stockerapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Credit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate date;
    private boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    public Credit() {
    }

    public Credit(Long id, Double amount, LocalDate date, Client client, Fournisseur fournisseur, boolean isPaid) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.client = client;
        this.fournisseur = fournisseur;
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        if(client == null){
            return "Credit{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", date=" + date +
                    ", isPaid=" + isPaid +
                    ", fournisseur=" + fournisseur.toString() +
                    '}';
        }else
        if(fournisseur == null){
            return "Credit{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", date=" + date +
                    ", isPaid=" + isPaid +
                    ", client=" + client.toString() +
                    '}';
        }
    return "";
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}