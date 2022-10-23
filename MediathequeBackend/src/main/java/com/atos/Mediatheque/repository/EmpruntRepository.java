package com.atos.Mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atos.Mediatheque.model.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{

	//	Trouver un user à partir de son ID avec tous les emprunts associés
	@Query("select u.emprunts from User u where u.id =:id")
	public List<Emprunt> findAllEmpruntByUserId(@Param("id") Long id);
	
}
