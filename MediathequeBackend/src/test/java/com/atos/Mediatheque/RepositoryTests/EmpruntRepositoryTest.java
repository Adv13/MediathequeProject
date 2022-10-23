package com.atos.Mediatheque.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;
import com.atos.Mediatheque.repository.EmpruntRepository;
import com.atos.Mediatheque.service.MediathequeServiceImplement;

public class EmpruntRepositoryTest {

	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	MediathequeServiceImplement empruntService;
	
	@BeforeEach
	public void assertEach() {
		System.out.println("................................EMPRUNT TEST..................................");
	}
	
	@Test
	void testRestituerItemById() {
		//Emprunt e = empruntService.effectuerEmprunt(1, 1);
		//System.out.println("Restituer item emprunté "+e);
			
	}
	
	@Test
	public void WhenUserTestMakeABorrowCheckIfHeCan() {
		
		User emprunteur = new User();
		emprunteur.setId(1l);
		
		List<Item> items = new ArrayList<>();
		Item item2 = new Item();
		item2.setId(2l);
		Item item3 = new Item();
		item3.setId(3L);
		
		items.add(item3);
		items.add(item2);
	
		Emprunt emprunt= empruntService.effectuerEmprunt(emprunteur, items);
		
		assertNotNull(emprunt.getNumero()); // getid?
		assertEquals(2, items.getNombreExemplaires().size()); //items ou emprunt?
		
	}
	
	@Test
	public void CheckIfTheListOfCopiesBorrowedAreEmpty() /*throws AvailableCopieException, QuotasExceedException, DepassementException, ItemNotFoundException*/ {

		Emprunt emprunt = new Emprunt();
		emprunt.setNumero(1L);
		emprunt.setDateRetour(Date(2022, 03, 26, 20, 20));
		emprunt.setDateEmprunt(LocalDateTime.of(2022,03,24,1,1));
		
		LocalDateTime a=emprunt.getDateEmprunt();
		LocalDateTime b=emprunt.getDateRetour();
		
		long differenceInDays = ChronoUnit.DAYS.between(a,b);
		
		List<Copie> copieList = new ArrayList<>();
		Copie copie =new Copie();
		copie.setId(2L);
		
		
		copieList.add(copie);
		
		
		emprunt.setCopies(copieList);
		
		Emprunt emprunt1=empruntService.restituerEmprunt(emprunt);
		
		assertEquals(0, emprunt1.getCopies().size()); 
													
		assertThat(differenceInDays).isLessThan(8); 
	}
}
