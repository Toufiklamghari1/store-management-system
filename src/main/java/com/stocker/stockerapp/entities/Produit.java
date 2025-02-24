package com.stocker.stockerapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Produit implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
    private Long idProduit;
	private String reference;
    private String libelle;
    private double prixUnitaire;
    private Double nbrArticles;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")

    private Categorie categorie;




	public Produit(Long idProduit, String reference, String libelle, double prixUnitaire, Double nbrArticles,
			Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.reference = reference;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.nbrArticles = nbrArticles;
		this.categorie = categorie;
	}

	public Produit() { }

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Double getNbrArticles() {
		return nbrArticles;
	}

	public void setNbrArticles(Double nbrArticles) {
		this.nbrArticles = nbrArticles;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}




}