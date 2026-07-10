package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookRepository repo = (BookRepository) context.getBean("bookRepository");
        repo.performAction();
        
        BookService service = (BookService) context.getBean("bookService");
        service.performAction();
    }
}
