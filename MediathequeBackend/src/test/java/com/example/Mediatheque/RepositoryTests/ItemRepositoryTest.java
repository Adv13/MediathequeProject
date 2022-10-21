package com.example.Mediatheque.RepositoryTests;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration
@SpringBootTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test

	void testByContainingTitreIgnoringCase() {
		Optional<Item> found = itemRepository.findBytitreContainingIgnoreCase("Tolkien");
		assertTrue(found.isPresent());
		
		Optional<Item> notFound = itemRepository.findBytitreContainingIgnoreCase("notFound");
		assertTrue(!notFound.isPresent());
	}
}
