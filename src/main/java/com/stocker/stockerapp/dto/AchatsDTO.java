package com.stocker.stockerapp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class AchatsDTO {

	private Long id;
	private String reference;
	private Long total;
	private Long idFournisseur;
	private Date achatDate;
	private List<LigneAchatDTO> ligneAchats;

	public AchatsDTO() {
		super();
	}



	public AchatsDTO(Long id, String reference, Long total, Long idFournisseur, Date achatDate,
			List<LigneAchatDTO> ligneAchats) {
		super();
		this.id = id;
		this.reference = reference;
		this.total = total;
		this.idFournisseur = idFournisseur;
		this.achatDate = achatDate;
		this.ligneAchats = ligneAchats;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	@JsonIgnore
	public List<LigneAchatDTO> getLigneAchats() {
		return ligneAchats;
	}
	public void setLigneAchats(List<LigneAchatDTO> ligneAchats) {
		this.ligneAchats = ligneAchats;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public Date getAchatDate() {
		return achatDate;
	}
	public void setAchatDate(Date achatDate) {
		this.achatDate = achatDate;
	}
}