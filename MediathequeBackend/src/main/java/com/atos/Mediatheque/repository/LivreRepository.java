package com.atos.Mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.Mediatheque.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
	

}
