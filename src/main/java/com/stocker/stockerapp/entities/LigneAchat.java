package com.stocker.stockerapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ligne_achat")
public class LigneAchat implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ligne_achat_id")
    private Long idLigneAchat;
    private Double quantite;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="achat_id",referencedColumnName="achat_id",nullable=false,unique=true)
    private Achats achats;

	public LigneAchat() {
		super();
	}

	public LigneAchat(Long id, Double quantite, Produit produit) {
		super();
		this.idLigneAchat = id;
		this.quantite = quantite;
		this.produit = produit;
	}


	public Long getIdLigneAchat() {
		return idLigneAchat;
	}

	public void setIdLigneAchat(Long idLigneAchat) {
		this.idLigneAchat = idLigneAchat;
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

	public Achats getAchats() {
		return achats;
	}

	public void setAchats(Achats achats) {
		this.achats = achats;
	}

}