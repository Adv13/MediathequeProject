package com.atos.Mediatheque.ServiceTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	public void whenAllIsOkEmpruntIsCreated() {
		
	}
}
