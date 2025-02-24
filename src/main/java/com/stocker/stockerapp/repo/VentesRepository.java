package com.stocker.stockerapp.repo;

import com.stocker.stockerapp.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentesRepository extends JpaRepository<Ventes, Long> {

}