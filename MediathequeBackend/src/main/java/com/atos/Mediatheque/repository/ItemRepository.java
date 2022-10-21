package com.atos.Mediatheque.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.Mediatheque.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	//	Rechercher tous les documents deja prédéfits dans la classe de JPARepository 
	//	
	//  Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.


	//  Permettre de voir les nouveautés, uniquement les CD
	//	@Query("select d from document d where d.dateParution> ?1")
	//	public List<Document> findByRecentDateParution(Date date); 

	//afficher les documents dont le titre contenant une chaîne particulière
	public Optional<Item> findByTitreContainingIgnoreCase(String chaineTitre);
	//afficher les documents par date de parution
	//public List<Item> findAllByDateParution(Date dateParution);
}
