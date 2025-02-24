package com.stocker.stockerapp.repo;


import com.stocker.stockerapp.entities.Client;
import com.stocker.stockerapp.entities.Credit;
import com.stocker.stockerapp.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findCreditByClient(Client client);
    List<Credit> findCreditByFournisseur(Fournisseur fournisseur);
    @Query(value = "SELECT * FROM credit c WHERE c.fournisseur_id is not null", nativeQuery = true)
    List<Credit> findCreditByFournisseurNotNull();
    @Query(value = "SELECT * FROM credit c WHERE c.client_id is not null", nativeQuery = true)
    List<Credit> findCreditByClientNotNull();
}