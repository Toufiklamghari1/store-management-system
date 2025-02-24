package com.stocker.stockerapp.repo;

import java.util.List;

import com.stocker.stockerapp.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

	@Query("SELECT f FROM Fournisseur f WHERE f.idFournisseur IN "
			+ "(SELECT a.idFournisseur FROM Achats a WHERE a.achatId IN "
			+ "(SELECT l.achats.achatId FROM LigneAchat l WHERE l.produit.idProduit = :produitId))")
	List<Fournisseur> findByProduitId(@Param("produitId") Long produitId);

	List<Fournisseur> findAll();

}