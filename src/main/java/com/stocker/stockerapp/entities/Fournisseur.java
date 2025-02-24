package com.stocker.stockerapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fournisseur_id")
	private Long idFournisseur;
	private String nom;
	private String prenom;
	private String adresse;
	private String numeroTele;

	@Override
	public String toString() {
		return "Fournisseur{" +
				"idFournisseur=" + idFournisseur +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", adresse='" + adresse + '\'' +
				", numeroTele='" + numeroTele + '\'' +
				'}';
	}

	public Fournisseur() {
		super();
	}
	public Fournisseur(Long idFournisseur, String nom, String prenom, String adresse, String numeroTele) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTele = numeroTele;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroTele() {
		return numeroTele;
	}
	public void setNumeroTele(String numeroTele) {
		this.numeroTele = numeroTele;
	}



}