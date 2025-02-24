package com.stocker.stockerapp.dto;

public class FournisseurDTO {

	private Long idFournisseur;
	private String nom;
	private String prenom;
	private String adresse;
	private String numeroTele;




	public FournisseurDTO() {
		super();
	}
	public FournisseurDTO(Long idFournisseur, String nom, String prenom, String adresse, String numeroTele) {
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