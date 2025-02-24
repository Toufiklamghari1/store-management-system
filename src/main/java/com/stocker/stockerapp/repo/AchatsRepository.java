package com.stocker.stockerapp.repo;

import com.stocker.stockerapp.entities.Achats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchatsRepository extends JpaRepository<Achats, Long> {

}