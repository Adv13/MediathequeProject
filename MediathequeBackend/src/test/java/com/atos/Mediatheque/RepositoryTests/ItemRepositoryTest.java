package com.atos.Mediatheque.RepositoryTests;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	void testByContainingTitreIgnoringCase() {
		Optional<Item> found = itemRepository.findByTitreContainingIgnoreCase("Tolkien");
		assertTrue(found.isPresent());
		
		Optional<Item> notFound = itemRepository.findByTitreContainingIgnoreCase("notFound");
		assertTrue(!notFound.isPresent());
	}
	
	@Test
	void testFindItemDisponible() {
		int nbrCopies = 0;
		List<Item> response = itemRepository.findItemDisponible();
		for (Item i : response) {
			if(i.getNombreExemplaires()>0) {
				nbrCopies+=1;
			}
		}
		System.out.println("Nombre d'items disponibles : " + nbrCopies);
		assertEquals(nbrCopies, itemRepository.findItemDisponible().size());
	}
	
	@Test
	void testFindItemDisponibleByDateParution() {
		Date date = new Date();
		date.setMonth(date.getMonth()-1);
		int nbreNewDocDispo=0;
		List<Item> response = itemRepository.findItemDisponibleByDateParution(date);
		for(Item i : response) {
			if ((i.getNombreExemplaires()>0) && (date.before(i.getDateParution() )) ) {
				nbreNewDocDispo+=1;
			}
		}
		System.out.println("Nombre d'items disponibles par date de parution "+ nbreNewDocDispo);
		assertEquals(nbreNewDocDispo, itemRepository.findItemDisponibleByDateParution(date).size());
		
	}
	

	
	//@Test
	//void testByContainingDateParution() {
	//	Optional<Item> found = itemRepository.findAllByDateParution(2022-06-14);
	//}
	
	
	/*
	 * @Test void testAddItem () { long initialItemCount = itemRepository.count();
	 * 
	 * Item newItem = new Item(); //newItem.setId(113);
	 * newItem.setTitre("NewTitle"); newItem.setDateParution(new Date());
	 * newItem.setNombreExemplaires(13);
	 * 
	 * itemRepository.save(newItem);
	 * 
	 * assertEquals(initialItemCount +1, itemRepository.count()); }
	 */
}
