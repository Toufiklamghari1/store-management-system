package com.stocker.stockerapp.service;

import java.util.ArrayList;
import java.util.List;

import com.stocker.stockerapp.entities.Categorie;
import com.stocker.stockerapp.repo.CategorieRepository;
import com.stocker.stockerapp.utils.ChartProduitDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public Categorie addCategorie(Categorie categorie) {
		return this.categorieRepository.save(categorie);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return this.categorieRepository.save(categorie);
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		this.categorieRepository.delete(categorie);

	}

	@Override
	public Categorie getCategorie(Long id) {
		return this.categorieRepository.getById(id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return this.categorieRepository.findAll();
	}

	public CategorieRepository getCategorieRepository() {
		return categorieRepository;
	}

	public void setCategorieRepository(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}

	@Override
	public List<ChartProduitDate> getCountProduitByCategorie() {
		List<ChartProduitDate> chartProduits = new ArrayList<>();
		List<Object[]> result = categorieRepository.countProduitsByCategorie();
		for (Object[] row : result) {
	        ChartProduitDate chartProduit = new ChartProduitDate();
	        chartProduit.setName((String) row[0]);
	        chartProduit.setValue((Long) row[1]);
	        chartProduits.add(chartProduit);
	    }
	    return chartProduits;
	}



}