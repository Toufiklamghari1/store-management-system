package com.stocker.stockerapp.utils;

import com.stocker.stockerapp.dto.LigneAchatDTO;

import java.util.Date;
import java.util.List;

public class AchatFactureRequest {

	private String factureReference;
	private String achatRef;
	private String fournisseurName;
	private Double total;
	private Date achatDate;
	private List<LigneAchatDTO> ligneAchat;

	public AchatFactureRequest() {
		super();
	}



	public AchatFactureRequest(String factureReference, String achatRef, String fournisseurName, Double total,
			Date achatDate, List<LigneAchatDTO> ligneAchat) {
		super();
		this.factureReference = factureReference;
		this.achatRef = achatRef;
		this.fournisseurName = fournisseurName;
		this.total = total;
		this.achatDate = achatDate;
		this.ligneAchat = ligneAchat;
	}

	public String getFactureReference() {
		return factureReference;
	}
	public void setFactureReference(String factureReference) {
		this.factureReference = factureReference;
	}
	public String getAchatRef() {
		return achatRef;
	}
	public void setAchatRef(String achatRef) {
		this.achatRef = achatRef;
	}
	public String getFournisseurName() {
		return fournisseurName;
	}
	public void setFournisseurName(String fournisseurName) {
		this.fournisseurName = fournisseurName;
	}
	public Date getAchatDate() {
		return achatDate;
	}
	public void setAchatDate(Date achatDate) {
		this.achatDate = achatDate;
	}
	public List<LigneAchatDTO> getLigneAchat() {
		return ligneAchat;
	}
	public void setLigneAchat(List<LigneAchatDTO> ligneAchat) {
		this.ligneAchat = ligneAchat;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}






}