package com.atos.Mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.Mediatheque.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	//	 Rechercher tous les documents deja prédéfit dans la classe de JPARepository 
	//	
	//  Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.


	//  Permettre de voir les nouveautés, uniquement les CD


	//afficher les documents dont le titre contenant une chaîne particulière
	public List<Item> findBytitreContainingIgnoreCase(String chaineTitre); 
}
