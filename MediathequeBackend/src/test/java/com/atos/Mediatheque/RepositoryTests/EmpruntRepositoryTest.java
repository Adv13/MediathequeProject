package com.atos.Mediatheque.RepositoryTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atos.Mediatheque.model.Emprunt;
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
}
