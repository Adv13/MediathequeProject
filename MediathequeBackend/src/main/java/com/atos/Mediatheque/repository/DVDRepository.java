package com.atos.Mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.Mediatheque.model.DVD;

public interface DVDRepository extends JpaRepository<DVD, Long> {
	

}
