package com.stocker.stockerapp.repo;

import com.stocker.stockerapp.entities.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LigneVenteRepository  extends JpaRepository<LigneVente, Long> {

}