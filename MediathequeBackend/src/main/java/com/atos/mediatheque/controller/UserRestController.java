package com.atos.mediatheque.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.UserRepository;
import com.atos.mediatheque.handlerException.UserNotFoundException;
import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.User;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

		@Autowired
		private UserRepository userRepository; 
		
		@Autowired
		private EmpruntRepository empruntRepository; 

	
		@GetMapping
		@JsonView(UsersViews.AllUsers.class)
		public List<User> findAllUser() {
			return userRepository.findAll(); 
		}
		
		@GetMapping("/{id_user}")
		@JsonView(UsersViews.OneUser.class)
		public User findOne(@PathVariable Long id_user) throws UserNotFoundException {
			return userRepository.fullLoad(id_user).orElseThrow(() -> new UserNotFoundException()); 
		}
	
		//Créer un user
		@PostMapping
		@JsonView(UsersViews.OneUser.class)
		public ResponseEntity<User> createUser(@RequestBody User user) {
			
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED); 
		} 
		
		//Mettre à jour un user
		@PutMapping
		@JsonView(UsersViews.OneUser.class)
		public User upDateUser(@RequestBody User user) throws UserNotFoundException {
			userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException());
			
			userRepository.save(user); 
			return user;
		}


		// Visualiser les emprunts d'un utilisateur
		@GetMapping("/{id_user}/emprunts")
		@JsonView(UsersViews.OneUser.class)
		public List<Emprunt> findAllEmpruntByUserId(@PathVariable Long id_user) throws UserNotFoundException {
			userRepository.findById(id_user).orElseThrow(() -> new UserNotFoundException()); 
			return empruntRepository.findAllEmpruntByUserId(id_user); 		
		}
}
