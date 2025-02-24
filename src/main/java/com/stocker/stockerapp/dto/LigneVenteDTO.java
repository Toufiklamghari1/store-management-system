package com.stocker.stockerapp.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stocker.stockerapp.entities.Produit;
import com.stocker.stockerapp.entities.Ventes;

public class LigneVenteDTO {

		private Long idLigneVente;
	    private Double quantite;
	    private Produit produit;

	    @JsonManagedReference
	    private Ventes ventes;

		public LigneVenteDTO() {
			super();
		}
		public LigneVenteDTO(Long idLigneVente, Double quantite, Produit produit, Ventes ventes) {
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