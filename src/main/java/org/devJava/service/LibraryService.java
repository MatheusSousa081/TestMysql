package org.devJava.service;

import org.devJava.book.Book;
import org.devJava.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private BookRepository repository;
    private List<Book> books;

    public LibraryService(BookRepository repository) {
        books = new ArrayList<>();
        this.repository = repository;
    }

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
        repository.registerBook(title, author, year);
    }

    public void getBooks() {
        repository.showBooks();
    }
}
