package com.atos.Mediatheque.RepositoryTests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.Mediatheque.model.User;
import com.atos.Mediatheque.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository; 
	
	@Test
	void testUpdateUser() {
		
		User userUpdate = userRepository.findById(1l).get(); 
		User userBeforeUpdate = userRepository.findById(1l).get(); 
		
		
		userUpdate.setLogin("nouveau@email.com"); 
		userUpdate.setPassword("newPassword");
		
		userRepository.save(userUpdate); 
		
		assertEquals(userUpdate.getNom(), userBeforeUpdate.getNom());
		assertEquals(userUpdate.getLogin(), "nouveau@email.com");
		
	}
}
