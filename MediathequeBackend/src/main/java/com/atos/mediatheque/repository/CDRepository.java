package com.atos.mediatheque.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.mediatheque.model.CD;

@Repository
public interface CDRepository extends JpaRepository<CD, Long> {

	

	
}