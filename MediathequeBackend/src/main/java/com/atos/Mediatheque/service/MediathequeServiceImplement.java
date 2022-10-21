package com.atos.Mediatheque.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;
import com.atos.Mediatheque.repository.EmpruntRepository;
import com.atos.Mediatheque.repository.ItemRepository;
import com.atos.Mediatheque.repository.UserRepository;

@Service
@Transactional
public class MediathequeServiceImplement implements IMediatheque {

	@Autowired
	private ItemRepository itemRepository; 

	@Autowired
	private EmpruntRepository empruntRepository; 

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Item> consulterItem() {

		return itemRepository.findAll();
	}

	@Override
	public Emprunt effectuerEmprunt(User user, List<Item> items) throws Exception {
		List<Item> itemEmprunt = new ArrayList();  

		for (Item item: items) {
			Item dr = itemRepository.findById(item.getId()).orElseThrow(() -> new Exception());
			if (dr.getNombreExemplaires() == 0) {
				throw new Exception();
			}
			dr.setNombreExemplaires(dr.getNombreExemplaires()-1);
			itemEmprunt.add(dr);
		}

		Emprunt emprunt = new Emprunt(); 
		emprunt.setDateEmprunt(new Date());
		emprunt.setItems(itemEmprunt);
		emprunt.setUser(user);


		if(user.getEmprunts().size() < 3) {
			empruntRepository.save(emprunt);
		} else {
			throw new Exception();
		}
		for ( Item item : itemEmprunt ) {
			itemRepository.save(item);
		}


		return emprunt;
	}


	@Override
	public void restituerEmprunt(User user, Emprunt emprunt) {
		List<Item> items = consulterItem();  
	
		for (Item itemDisponible: items) {
			for (Item itemEmprunter: emprunt.getItems() ) {
				if ((itemDisponible.getId()== itemEmprunter.getId())) {
					itemDisponible.setNombreExemplaires(itemDisponible.getNombreExemplaires()+1);
				}
			}
		}

	empruntRepository.save(emprunt); 
}

//	@Override
//	public List<Emprunt> visualiserEmprunt(User user, Emprunt emprunt) {
	//		
	//		return empruntRepository.visualiserEmprunt(user, emprunt); 
	//	}
}
