package com.atos.mediatheque.repositoryTests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.mediatheque.model.User;
import com.atos.mediatheque.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository; 
	
	@BeforeEach
	public void assertEach() {
		System.out.println("................................USER TEST..................................");
	}
	
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
