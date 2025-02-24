package com.stocker.stockerapp.service;

import com.stocker.stockerapp.entities.Categorie;
import com.stocker.stockerapp.utils.ChartProduitDate;

import java.util.List;


public interface CategorieService {

	Categorie addCategorie(Categorie categorie);
	Categorie updateCategorie(Categorie categorie);
	void deleteCategorie(Categorie categorie);
	Categorie getCategorie(Long id);
	List<Categorie> getAllCategories();
	List<ChartProduitDate> getCountProduitByCategorie();


}