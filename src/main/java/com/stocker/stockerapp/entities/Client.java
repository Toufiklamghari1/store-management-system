package com.stocker.stockerapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long clientId;
	private String nom;
	private String prenom;
	private String adresse;
	private String numeroTele;


	@Override
	public String toString() {
		return "Client{" +
				"clientId=" + clientId +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", adresse='" + adresse + '\'' +
				", numeroTele='" + numeroTele + '\'' +
				'}';
	}

	public Client() {
		super();
	}
	public Client(Long clientId, String nom, String prenom, String adresse, String numeroTele) {
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