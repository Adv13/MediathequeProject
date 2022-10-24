package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.model.DVD;

public interface DVDRepository extends JpaRepository<DVD, Long> {
	

}
