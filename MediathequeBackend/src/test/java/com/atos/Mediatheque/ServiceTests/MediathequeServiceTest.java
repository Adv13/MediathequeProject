package com.atos.Mediatheque.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;
import com.atos.Mediatheque.repository.EmpruntRepository;
import com.atos.Mediatheque.repository.ItemRepository;
import com.atos.Mediatheque.service.IMediatheque;

public class MediathequeServiceTest {

	@Autowired
	IMediatheque mediathequeService;

	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	
	public void whenAllIsOkEmpruntIsCreated() throws Exception {
		
		User user2 = new User();
		user2.setId(2l);

		List<Item> docs = new ArrayList<>();
		Item doc1 = new Item();
		doc1.setId(1l);
		Item doc2 = new Item();
		doc2.setId(2l);
		docs.add(doc1);
		docs.add(doc2);
		
		Emprunt emprunt = mediathequeService.effectuerEmprunt(user2, docs);
		
		assertNotNull(emprunt.getNumero());
		assertTrue(emprunt.getItems().size() == 2);
		
	}
}
