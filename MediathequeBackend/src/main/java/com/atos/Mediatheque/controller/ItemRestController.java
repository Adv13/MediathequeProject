package com.atos.Mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.Mediatheque.model.CD;
import com.atos.Mediatheque.model.DVD;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.Livre;
import com.atos.Mediatheque.repository.ItemRepository;

@RestController
@RequestMapping("/mediatheque/catalogue")
public class ItemRestController {

		@Autowired
		private ItemRepository itemRepository; 
	
	
		@GetMapping
		public List<Item> findAllItem () {
			return itemRepository.findAll(); 
	
		}
	
		@GetMapping("/CD")
		public List<Item> findAllCD () {
			if ( itemRepository instanceof CD)
				return itemRepository.findAll();
			return null; 	
		}
	
		@GetMapping("/Livre")
		public List<Item> findAllLivre () {
			if ( itemRepository instanceof Livre)
				return itemRepository.findAll();
			return null; 	
		}
	
		@GetMapping("/DVD")
		public List<Item> findAllDvd () {
			if ( itemRepository instanceof DVD)
				return itemRepository.findAll();
			return null; 	
		}


		//afficher les documents dont le titre contenant une chaîne particulière
		// pour voir sur le web on test sur l navigateur : http://localhost:8080/mediatheque/catalogue/search?q=ga, ga c'est la chaine recherché!
		@GetMapping("/search")
		public List<Item>  searchItemByString(@RequestParam String q) {

			return itemRepository.findBytitreContainingIgnoreCase(q); 
		}
}
