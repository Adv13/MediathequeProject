package com.atos.mediatheque.repositoryTests;

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

import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.User;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.service.MediathequeServiceImplement;

//@DataJpaTest
public class EmpruntRepositoryTest {

	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	MediathequeServiceImplement empruntService;
	
	@BeforeEach
	public void assertEach() {
		System.out.println("................................EMPRUNT TEST..................................");
	}
	
	//A retravailler plus tard
	
	/*
	 * @Test void testRestituerItemById() throws Exception {
	 * 
	 * User user = new User(); user.setId(1l); List<Item> docs = new ArrayList<>();
	 * Item doc1 = new Item(); doc1.setId(4l); docs.add(doc1);
	 * 
	 * Emprunt e = empruntService.effectuerEmprunt(user, docs);
	 * System.out.println("Restituer item emprunté : "+e);
	 * 
	 * }
	 */
	
	//A retravailler plus tard
	
	/*
	 * @Test void testFindByUsers() throws Exception{
	 * 
	 * User user = new User(); user.setId(1l); List<Item> docs = new ArrayList<>();
	 * Item doc1 = new Item(); doc1.setId(4l); docs.add(doc1);
	 * 
	 * 
	 * Emprunt e = empruntService.effectuerEmprunt(user, docs);
	 * 
	 * List<Emprunt> findByUserResult = empruntRepository.findEmpruntById(user);
	 * assertTrue(findByUserResult.size() > 0); }
	 */
}
