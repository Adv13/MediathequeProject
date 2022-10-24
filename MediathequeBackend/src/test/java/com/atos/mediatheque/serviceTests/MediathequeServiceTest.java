package com.atos.mediatheque.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.User;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.service.IMediatheque;


@SpringBootTest
//@DataJpaTest
public class MediathequeServiceTest {

	@Autowired
	IMediatheque mediathequeService;

	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@BeforeEach
	public void assertEach() {
		System.out.println("...............................MEDIATHEQUE TEST...................................");
	}

	@Test
	@Transactional
	public void whenAllIsOkEmpruntIsCreated() throws Exception {
		
		User user2 = new User();
		user2.setId(2l);

		List<Item> docs = new ArrayList<>();
		Item doc1 = new Item();
		doc1.setId(13l);
		Item doc2 = new Item();
		doc2.setId(24l);
		docs.add(doc1);
		docs.add(doc2);
		
		Emprunt emprunt = mediathequeService.effectuerEmprunt(user2, docs);
		
		assertNotNull(emprunt.getNumero());
		assertTrue(emprunt.getItems().size() == 2);
		
	}
	
	@Test
	@Transactional
	public void whenQuotaExceedThrowException() {
		User user1 = new User();
		user1.setId(1l);

		List<Item> docs = new ArrayList<>();
		Item doc1 = new Item();
		doc1.setId(4l);
		Item doc2 = new Item();
		doc2.setId(5l);
		Item doc3 = new Item();
		doc3.setId(2l);
		Item doc4 = new Item();
		doc4.setId(6l);
		docs.add(doc1);
		docs.add(doc2);
		//docs.add(doc3);
		//docs.add(doc4);

		try {
			Emprunt emprunt = mediathequeService.effectuerEmprunt(user1, docs);
			fail("Exception not thrown" + emprunt);
		} catch (Exception e) {
			System.out.println("OK");
		}
	}

	@Test 
	@Transactional
	public void whenEmpruntIsRestored() throws Exception {
		
		Emprunt emprunt = new Emprunt();
		emprunt.setNumero(1l);
		
		mediathequeService.restituerEmprunt(emprunt);
		
		assertEquals(0, empruntRepository.findAll().size() == 0);
		System.out.println("******************************" + itemRepository.findById(3l).get().getNombreExemplaires()); 
		
		//assertTrue(itemRepository.findById(3l).get().getNombreExemplaires() == 61); 
		assertEquals(265, itemRepository.findById(3l).get().getNombreExemplaires());
	}
}
