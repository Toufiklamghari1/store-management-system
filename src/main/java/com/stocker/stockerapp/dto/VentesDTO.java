package com.stocker.stockerapp.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stocker.stockerapp.entities.LigneVente;

public class VentesDTO {

	private Long venteId;
	private String reference;
	private Long total;
	private Date venteDate;
	private Long idClient;

    private List<LigneVente> ligneVentes;

	public VentesDTO() {
		super();
	}



	public VentesDTO(Long venteId, String reference, Long total, Date venteDate, Long idClient,
			List<LigneVente> ligneVentes) {
		super();
		this.venteId = venteId;
		this.reference = reference;
		this.total = total;
		this.venteDate = venteDate;
		this.idClient = idClient;
		this.ligneVentes = ligneVentes;
	}



	public Long getVenteId() {
		return venteId;
	}
	public void setVenteId(Long venteId) {
		this.venteId = venteId;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Date getVenteDate() {
		return venteDate;
	}
	public void setVenteDate(Date venteDate) {
		this.venteDate = venteDate;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	@JsonIgnore
	public List<LigneVente> getLigneVentes() {
		return ligneVentes;
	}
	public void setLigneVentes(List<LigneVente> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}





}