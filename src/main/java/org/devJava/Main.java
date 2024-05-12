package org.devJava;

import org.devJava.repository.BookRepository;
import org.devJava.service.LibraryService;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        LibraryService libraryService = LibraryService.createLibraryService(repository);

        repository.createConnection();
        libraryService.addBook("Java Efetivo", "Joshua Bloch", Year.of(2019));
        libraryService.getBooks();
        repository.closeConnection();
    }
}
