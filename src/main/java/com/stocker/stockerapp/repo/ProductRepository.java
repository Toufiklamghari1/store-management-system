package com.stocker.stockerapp.repo;

import java.util.List;

import com.stocker.stockerapp.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Produit, Long> {
	List<Produit> findAll();
}