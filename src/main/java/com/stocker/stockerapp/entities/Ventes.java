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

@Entity
@Table(name = "vente")
public class Ventes implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vente_id")
	private Long venteId;
	private String reference;
	private Long total;
	private Date venteDate;
	private Long idClient;

	@OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;

	public Ventes() {
		super();
	}



	public Ventes(Long venteId, String reference, Long total, Date venteDate, Long idClient,
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