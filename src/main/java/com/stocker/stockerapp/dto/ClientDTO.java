package com.stocker.stockerapp.dto;

public class ClientDTO {

	private Long clientId;
	private String nom;
	private String prenom;
	private String adresse;
	private String numeroTele;



	public ClientDTO() {
		super();
	}
	public ClientDTO(Long clientId, String nom, String prenom, String adresse, String numeroTele) {
		super();
		this.clientId = clientId;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTele = numeroTele;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
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