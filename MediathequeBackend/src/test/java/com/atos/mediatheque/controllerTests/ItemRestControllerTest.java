package com.atos.mediatheque.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.atos.mediatheque.model.Item;

public class ItemRestControllerTest {

	@Autowired
	RestTemplate restTemplate; 
	
	@Test 
	public void whenGetDocumentReturn200 () {
		
		Item item = restTemplate.getForObject("/", Item.class); 
	}
}
