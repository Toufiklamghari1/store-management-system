package com.stocker.stockerapp.service;

import java.util.List;

import com.stocker.stockerapp.entities.Produit;
import com.stocker.stockerapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Produit getProduit(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public List<Produit> getAllProduit() {
		return productRepository.findAll();
	}

	@Override
	public Produit saveProduit(Produit produit) {
		return productRepository.save(produit);
	}

}