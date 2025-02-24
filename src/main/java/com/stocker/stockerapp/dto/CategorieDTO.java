package com.stocker.stockerapp.dto;


public class CategorieDTO {

	 private Long idCategorie;
	 private String description;


	public CategorieDTO() {
		super();
	}

	public CategorieDTO(Long idCategorie, String description) {
		super();
		this.idCategorie = idCategorie;
		this.description = description;
	}



	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}