package com.stocker.stockerapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_vente")
public class LigneVente implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ligne_vente_id")
    private Long idLigneVente;
    private Double quantite;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="vente_id",referencedColumnName="vente_id",nullable=false,unique=true)
    private Ventes ventes;


	public LigneVente() {
		super();
	}

	public LigneVente(Long idLigneVente, Double quantite, Produit produit, Ventes ventes) {
		super();
		this.idLigneVente = idLigneVente;
		this.quantite = quantite;
		this.produit = produit;
		this.ventes = ventes;
	}

	public Long getIdLigneVente() {
		return idLigneVente;
	}

	public void setIdLigneVente(Long idLigneVente) {
		this.idLigneVente = idLigneVente;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Ventes getVentes() {
		return ventes;
	}

	public void setVentes(Ventes ventes) {
		this.ventes = ventes;
	}



}