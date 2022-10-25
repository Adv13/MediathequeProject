package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.User;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UserRepository;

import com.atos.mediatheque.handlerException.DocumentNotFoundException;
import com.atos.mediatheque.handlerException.EmpruntNotFoundException;
import com.atos.mediatheque.handlerException.QuotaExceetException;
import com.atos.mediatheque.handlerException.ResourceNotAvalaibleException;
import com.atos.mediatheque.handlerException.UserNotFoundException;

@Service
@Transactional
public class MediathequeServiceImplement implements IMediatheque {

	@Autowired
	private ItemRepository itemRepository; 

	@Autowired
	private EmpruntRepository empruntRepository; 

	@Autowired
	private UserRepository userRepository;

	
	public List<Item> consulterItem() {
	 
	return itemRepository.findAll(); }

	@Override
	public Emprunt effectuerEmprunt(User user, List<Item> items) throws Exception {
		List<Item> itemEmprunt = new ArrayList<>();  

		for (Item item: items) {
			Item dr = itemRepository.findById(item.getId()).orElseThrow(() -> new DocumentNotFoundException());
			if (dr.getNombreExemplaires() == 0) {
				throw new ResourceNotAvalaibleException();
			}
			dr.setNombreExemplaires(dr.getNombreExemplaires()-1);
			itemEmprunt.add(dr);
		}
		
		user = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException()); 
		int nbDocuments = 0;
		for ( Emprunt emprunt : user.getEmprunts() ) {
			nbDocuments += emprunt.getItems().size();
		}
		if (nbDocuments + items.size() > 3) {
			throw new QuotaExceetException ();
		}

		Emprunt emprunt = new Emprunt(); 
		emprunt.setDateEmprunt(new Date());
		emprunt.setDateRetour(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)));
		emprunt.setItems(itemEmprunt);
		emprunt.setUser(user);


		empruntRepository.save(emprunt);

		for (Item item : itemEmprunt) {
			itemRepository.save(item);
		}
		return emprunt;
	}


	@Override
	public void restituerEmprunt(Emprunt emprunt) throws Exception {
		emprunt = empruntRepository.findById(emprunt.getNumero()).orElseThrow(() -> new EmpruntNotFoundException());
		List<Item> itemEmprunt = emprunt.getItems();
		emprunt.setDateRetour(new Date());
		for (Item doc : itemEmprunt) {
			Item dr = itemRepository.findById(doc.getId()).orElseThrow(() -> new DocumentNotFoundException()); 
			dr.setNombreExemplaires(dr.getNombreExemplaires() + 1);
			itemRepository.save(dr);
		}

		empruntRepository.deleteById(emprunt.getNumero()); 
		// save et update date de retour plutot ?
}

//	@Override
//	public List<Emprunt> visualiserEmprunt(User user, Emprunt emprunt) {
	//		
	//		return empruntRepository.visualiserEmprunt(user, emprunt); 
	//	}
}
