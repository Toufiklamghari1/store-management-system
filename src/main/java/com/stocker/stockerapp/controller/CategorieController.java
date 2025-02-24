package com.stocker.stockerapp.controller;

import java.util.List;
import java.util.Optional;

import com.stocker.stockerapp.entities.Categorie;
import com.stocker.stockerapp.service.CategorieServiceImpl;
import com.stocker.stockerapp.utils.ChartProduitDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	CategorieServiceImpl categorieServiceImpl;


	@GetMapping("/allCategories")
	public List<Categorie> getCategorie(){
		return categorieServiceImpl.getAllCategories();

	}

	@PostMapping("/add")
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieServiceImpl.addCategorie(categorie);

	}

	@PutMapping
	public Categorie updateCategorie(@RequestBody() Categorie categorie) {
		return categorieServiceImpl.updateCategorie(categorie);

	}

	@DeleteMapping("/deleteCategorie/{id}")
	public void deleteCategorie(@PathVariable("id") Long id) {
		categorieServiceImpl.deleteCategorie(categorieServiceImpl.getCategorie(id));

	}

	@GetMapping("/getCountProduitByCategorie")
	public List<ChartProduitDate> getCountProduitByCategorie(){
		return categorieServiceImpl.getCountProduitByCategorie();

	}





}