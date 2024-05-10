package org.devJava;

import org.devJava.book.Book;
import org.devJava.repository.BookRepository;
import org.devJava.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        LibraryService libraryService = new LibraryService(repository);

        repository.createConnection();
        libraryService.addBook("Assim que começa", "CoHo", 2020);
        libraryService.getBooks();
        repository.closeConnection();
    }
}
