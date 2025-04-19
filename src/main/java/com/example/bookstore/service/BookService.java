package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

//    public List<Book> userData(){
//        List<Book> data = new ArrayList<>();
//        List<Book> books = bookRepository.findByUserIdIn(userIds);
//        data
//        return data;
//    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<String> getUserRoles(String username) {
        if ("user".equals(username)) {
            return Arrays.asList("ROLE_USER");
        } else if ("admin".equals(username)) {
            return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        }
        System.out.println("rolesbookservice");
        return Arrays.asList("ROLE_GUEST");
    }
}