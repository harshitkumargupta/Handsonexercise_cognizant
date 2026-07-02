package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performAction() {
        System.out.println("BookService action performed.");
        if (bookRepository != null) {
            System.out.println("Invoking BookRepository from BookService:");
            bookRepository.performAction();
        } else {
            System.out.println("BookRepository is null. Dependency Injection failed.");
        }
    }
}
