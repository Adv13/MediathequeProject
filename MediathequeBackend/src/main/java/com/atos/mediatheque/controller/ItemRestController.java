package com.atos.mediatheque.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.model.CD;
import com.atos.mediatheque.model.DVD;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.Livre;
import com.atos.mediatheque.repository.CDRepository;
import com.atos.mediatheque.repository.DVDRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.LivreRepository;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {

		@Autowired
		private ItemRepository itemRepository; 
		
		@Autowired
		private CDRepository cdRepository; 

		@Autowired
		private DVDRepository dvdRepository; 

		@Autowired
		private LivreRepository livreRepository; 
	
		
		//Afficher tous les documents,
		//avec un titre contenant une chaîne particulière
		//avec une date de parution ou avec le type document ( CD/DVD/LIVRE)
		//Pour tester sur le navigateur : http://localhost:8080/mediatheque/catalogue/search?q=ga, ga c'est la chaine recherchée!
		//, @RequestParam Date requestDateParution, @RequestParam String typeDocument
		//	@GetMapping("/search")
		//	public Optional<Document>  searchDocumentByString(@RequestParam String q) {
		//		return documentRepository.findAllByTitreContainingIgnoreCase(q); 
		//		
		//	}
		@GetMapping
		public ResponseEntity<List<Item>> getDocuments(@RequestParam(required = false) String titre, @RequestParam (required = false) Date dateParution, @RequestParam (required = false) String typeItem) throws ParseException {
			
//			Date dateParution = new SimpleDateFormat("dd-MM-yyyy").parse(sDateParution);
//			System.out.println("DATE : "+ dateParution);
			try {
				List<Item> items = new java.util.ArrayList<>();
				if (dateParution == null) {

					if (typeItem == null) 

						if (titre == null)
							itemRepository.findAll().forEach(items::add);
						else 
							itemRepository.findAllByTitreContainingIgnoreCase(titre).forEach(items::add); 
					else {

						if (typeItem.equals("CD")) 
							cdRepository.findAll().forEach(items::add); 
						if (typeItem.equals("DVD"))
							dvdRepository.findAll().forEach(items::add); 
						if (typeItem.equals("LIVRE"))
							livreRepository.findAll().forEach(items::add); 
					}
				}
				else 
					itemRepository.findAllByDateParution(dateParution).forEach(items::add); 

				if (items.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(items, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	////  Visualiser les nouveautés, uniquement les CD
//		@GetMapping("/NouveauCD")
//		public ResponseEntity<List<Document>> findAllNewCD () {
//			Date date = new Date(); 
//			
//			date.setMonth(date.getMonth()-1); 
//			
//			try {
//				List<Document> documents = new java.util.ArrayList<>();
//				documentRepository.findByRecentDateParution().forEach(documents::add); 
//				
	//	
//				return new ResponseEntity<>(documents, HttpStatus.OK);
//			}
//			catch (Exception e) {
//				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}


		// ajouter un nouveau item
		@PostMapping
		public Item addItemToCatalogue(@RequestBody Item item) {
			itemRepository.save(item); 
			return item; 
		}

		
		
		
		/*
		 * @GetMapping public List<Item> findAllItem () { return
		 * itemRepository.findAll();
		 * 
		 * }
		 * 
		 * @GetMapping("/cd") public List<Item> findAllCD () { if ( itemRepository
		 * instanceof CD) return itemRepository.findAll(); return null; }
		 * 
		 * @GetMapping("/livre") public List<Item> findAllLivre () { if ( itemRepository
		 * instanceof Livre) return itemRepository.findAll(); return null; }
		 * 
		 * @GetMapping("/dvd") public List<Item> findAllDvd () { if ( itemRepository
		 * instanceof DVD) return itemRepository.findAll(); return null; }
		 */


		/*
		 * //afficher les documents dont le titre contenant une chaîne particulière //
		 * pour voir sur le web on test sur l navigateur :
		 * http://localhost:8080/mediatheque/catalogue/search?q=ga, ga c'est la chaine
		 * recherché!
		 * 
		 * @GetMapping("/search") public List<Item> searchItemByString(@RequestParam
		 * String q) {
		 * 
		 * return itemRepository.findBytitreContainingIgnoreCase(q); }
		 */
}
