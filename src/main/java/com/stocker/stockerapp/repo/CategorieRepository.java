package com.stocker.stockerapp.repo;

import java.util.List;

import com.stocker.stockerapp.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	@Query(value = "select type,count(type) from location group by type", nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();

	public Categorie findByDescription(String desc);

	@Query("SELECT c.description, COUNT(p) FROM Produit p JOIN p.categorie c GROUP BY c.description")
    List<Object[]> countProduitsByCategorie();
}