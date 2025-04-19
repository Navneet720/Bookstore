package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
		// Test to verify the repository is working
		List<Book> books = bookRepository.findAll();
		assertThat(books).isNotNull();
	}
}