package org.devJava.service;

import org.devJava.book.Book;
import org.devJava.repository.BookRepository;
import org.jetbrains.annotations.NotNull;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryService {
    private BookRepository repository;
    private List<Book> books;

    public LibraryService(BookRepository repository) {
        books = new ArrayList<>();
        this.repository = repository;
    }

    public static LibraryService createLibraryService(@NotNull BookRepository bookRepository) {
        return new LibraryService(bookRepository);
    }

    public void addBook(@NotNull String title,@NotNull String author,@NotNull Year year) {
        books.add(new Book(title, author, year));
        repository.registerBook(title, author, year);
    }

    public void getBooks() {
        repository.showBooks();
    }

    public void removeBook(@NotNull String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title ));
        repository.removeBook(title);
    }
}
