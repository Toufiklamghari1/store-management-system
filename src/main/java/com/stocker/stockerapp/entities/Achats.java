package com.stocker.stockerapp.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "achat")
public class Achats implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "achat_id")
	private Long achatId;
	private String reference;
	private Long total;
	private Date achatDate;
	private Long idFournisseur;

	@OneToMany(mappedBy = "achats")
    private List<LigneAchat> ligneAchats;

	public Achats() {
		super();
	}

	public Achats(Long achatId, String reference, Long total, Date achatDate, Long idFournisseur,
			List<LigneAchat> ligneAchats) {
		super();
		this.achatId = achatId;
		this.reference = reference;
		this.total = total;
		this.achatDate = achatDate;
		this.idFournisseur = idFournisseur;
		this.ligneAchats = ligneAchats;
	}



	public Long getAchatId() {
		return achatId;
	}

	public void setAchatId(Long achatId) {
		this.achatId = achatId;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<LigneAchat> getLigneAchats() {
		return ligneAchats;
	}

	public void setLigneAchats(List<LigneAchat> ligneAchats) {
		this.ligneAchats = ligneAchats;
	}

	@Override
	public String toString() {
		return "Achats [achatId=" + achatId + ", total=" + total + ", fournisseur=" + idFournisseur + ", ligneAchats="
				+ ligneAchats + "]";
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



	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}








}