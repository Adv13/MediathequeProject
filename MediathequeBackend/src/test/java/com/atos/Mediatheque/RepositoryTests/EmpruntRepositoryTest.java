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
import org.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.atos.Mediatheque.model.Copie;
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
	void testRestituerItemById() throws Exception {
		
		User user = new User();
		user.setId(1l);
		List<Item> docs = new ArrayList<>();
		Item doc1 = new Item();
		doc1.setId(4l);
		docs.add(doc1);
		
		Emprunt e = empruntService.effectuerEmprunt(user, docs);
		System.out.println("Restituer item emprunté : "+e);
			
	}
	
	
    @Test
    void testFindByUsers() throws Exception{
    	
        User user = new User();
        user.setId(1l);
		List<Item> docs = new ArrayList<>();
		Item doc1 = new Item();
		doc1.setId(4l);
		docs.add(doc1);
        
        
        Emprunt e = empruntService.effectuerEmprunt(user, docs);
        user.setId(2l);

        List<Emprunt> findByUserResult = empruntRepository.findEmpruntById(user);
        assertTrue(findByUserResult.size() > 0);
    }
}
