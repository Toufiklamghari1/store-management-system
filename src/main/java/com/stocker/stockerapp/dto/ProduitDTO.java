package com.stocker.stockerapp.dto;


public class ProduitDTO {

	private int idProduit;
	private String reference;
    private String libelle;
    private double prixUnitaire;
    private Double nbrArticles;

    private CategorieDTO categorie;

	public ProduitDTO() {
		super();
	}



	public ProduitDTO(int idProduit, String reference, String libelle, double prixUnitaire, Double nbrArticles,
			CategorieDTO categorie) {
		super();
		this.idProduit = idProduit;
		this.reference = reference;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.nbrArticles = nbrArticles;
		this.categorie = categorie;
	}



	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
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
	public CategorieDTO getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieDTO categorie) {
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