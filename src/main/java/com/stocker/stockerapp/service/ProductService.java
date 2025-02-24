package com.stocker.stockerapp.service;

import com.stocker.stockerapp.entities.Produit;

import java.util.List;

public interface ProductService {

	Produit getProduit(Long id);
	List<Produit> getAllProduit();
	Produit saveProduit(Produit produit);

}