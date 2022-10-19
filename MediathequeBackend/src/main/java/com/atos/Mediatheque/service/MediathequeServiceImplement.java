package com.atos.Mediatheque.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;
import com.atos.Mediatheque.repository.EmpruntRepository;
import com.atos.Mediatheque.repository.ItemRepository;

@Service
@Transactional
public class MediathequeServiceImplement implements IMediatheque {

	@Autowired
	private ItemRepository itemRepository; 

	@Autowired
	private EmpruntRepository empruntRepository; 

	@Override
	public List<Item> consulterItem() {

		return itemRepository.findAll();
	}

	@Override
	public void effectuerEmprunt(User user, Emprunt emprunt) {
		List<Item> items = consulterItem();  

		for (Item itemDisponible: items) {
			for (Item itemEmprunter: emprunt.getItems() ) {
				if ((itemDisponible.getId()== itemEmprunter.getId()) && itemEmprunter.getNombreExemplaires()> 0) {
					itemDisponible.setNombreExemplaires(itemDisponible.getNombreExemplaires()-1);
				}
			}
		}

		empruntRepository.save(emprunt); 


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
