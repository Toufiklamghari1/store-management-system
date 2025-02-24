package com.stocker.stockerapp.repo;

import java.util.List;

import com.stocker.stockerapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long>  {

	List<Client> findAll();
}