package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.mediatheque.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

	
	
}
