package com.stocker.stockerapp.dto;

import com.stocker.stockerapp.entities.Achats;
import com.stocker.stockerapp.entities.Produit;


public class LigneAchatDTO {

	private Long idLigneAchat;
    private Double quantite;
    private Produit produit;
    private Achats achats;

	public LigneAchatDTO() {
		super();
	}
	public LigneAchatDTO(Long idLigneAchat, Double quantite, Produit produit, Achats achats) {
		super();
		this.idLigneAchat = idLigneAchat;
		this.quantite = quantite;
		this.produit = produit;
		this.achats = achats;
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
	@Override
	public String toString() {
		return "LigneAchatDTO [idLigneAchat=" + idLigneAchat + ", quantite=" + quantite + ", produit=" + produit
				+ ", achats=" + achats + "]";
	}


}