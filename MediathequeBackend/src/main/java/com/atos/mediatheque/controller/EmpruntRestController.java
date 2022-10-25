package com.atos.mediatheque.controller;


import java.util.List;

import com.atos.mediatheque.handlerException.EmpruntNotFoundException;
import com.atos.mediatheque.handlerException.UserNotFoundException;
import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.UserRepository;
import com.atos.mediatheque.service.IMediatheque;

@RestController
@RequestMapping("/api")
public class EmpruntRestController {
	
	@Autowired
	private IMediatheque iMediatheque;
	@Autowired
	private EmpruntRepository empruntRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/emprunts/{id_emprunt}")
	public Emprunt effectuerEmprunt(@PathVariable Long id_emprunt,@RequestBody List<Item> items) throws Exception {
		User user = userRepository.findById(id_emprunt).orElseThrow(() -> new UserNotFoundException());
		user.setId(id_emprunt); 
		return iMediatheque.effectuerEmprunt(user, items);
	}

	@DeleteMapping("/emprunts/{id_emprunt}")
	public void restituerEmprunt(@PathVariable Long  id_emprunt) throws Exception {
		Emprunt emprunt = empruntRepository.findById(id_emprunt).orElseThrow(() -> new EmpruntNotFoundException ()); 
		emprunt.setNumero(id_emprunt); 
		iMediatheque.restituerEmprunt(emprunt);
	} 
	
	
	
	
}
