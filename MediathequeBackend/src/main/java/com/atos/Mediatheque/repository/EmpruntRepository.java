package com.atos.Mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.Mediatheque.model.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{

	//
	//	@Query("select e from Emprunt e where e.user.id=:id order by e.dateEmprunt desc")
	//	public List<Emprunt> visualiserEmprunt(User user, Emprunt emprunt); 
	
}
