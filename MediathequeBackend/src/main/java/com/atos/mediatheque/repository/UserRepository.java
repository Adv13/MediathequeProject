package com.atos.mediatheque.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.mediatheque.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//	CRUD sur users et items déjà surchargé en JPARepository
		
		
	//	Trouver un user pour un login et un mot de passe donné
		public User findByLoginAndPassword(String login, String password); 
		
	//	Compter les membres déjà prédéfit dans la classe JPARepository
	
	
	//	Trouver un user à partir de son ID avec tous les emprunts associés pré-chargés
	
	    @Query("from User u left join fetch u.emprunts where u.id =:id")
	    public Optional<User> fullLoad(Long id);
	
	    public Optional<User> findByLogin(String login); 
	
	 // sauvegarder un client 
	 // public User saveUser(User user); 
}
