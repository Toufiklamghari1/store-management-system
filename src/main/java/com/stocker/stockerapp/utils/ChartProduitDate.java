package com.stocker.stockerapp.utils;

public class ChartProduitDate {

	private String name;
	private Long value;

	public ChartProduitDate() {
		super();
	}
	public ChartProduitDate(String name, Long value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}




}