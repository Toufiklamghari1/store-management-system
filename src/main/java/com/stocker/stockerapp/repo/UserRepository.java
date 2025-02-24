package com.stocker.stockerapp.repo;


import com.stocker.stockerapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByNom(String username);

}