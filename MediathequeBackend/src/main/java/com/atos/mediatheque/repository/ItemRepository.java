package com.atos.mediatheque.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atos.mediatheque.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	// ReadALL dispo
	@Query("select i from Item i where i.nombreExemplaires >0")
	public List<Item> findItemDisponible();
	
	
	//ReadALL dispo et new 
	@Query("select i from Item i where i.nombreExemplaires >0 and i.dateParution > ?1")
	public List<Item> findItemDisponibleByDateParution(Date date);
	

	// restituer l'emprunte ==> le document est retourné
	@Modifying // modification de base car on utilse update oe delete 
	@javax.transaction.Transactional
	@Query("update Item i set i.nombreExemplaires =i.nombreExemplaires +1 where i.id=?1")
	public void restituerItemById(long id);
	
	
	//  Permettre de voir les nouveautés, uniquement les CD
	//	@Query("select d from item d where d.dateParution> ?1")
	//	public List<Document> findByRecentDateParution(Date date); 

	//afficher les documents dont le titre contenant une chaîne particulière
	public Optional<Item> findByTitreContainingIgnoreCase(String chaineTitre);
	public List<Item> findBytitreContainingIgnoreCase(String chaineTitre);
	//afficher les documents par date de parution
	public List<Item> findAllByDateParution(Date dateParution);
	
	//afficher les documents dont le titre contenant une chaîne particulière
	public List<Item> findAllByTitreContainingIgnoreCase(String chaineTitre); 


	
}
