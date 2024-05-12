package org.devJava;

import org.devJava.repository.BookRepository;
import org.devJava.service.LibraryService;

import java.sql.SQLException;
import java.time.Year;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookRepository repository = new BookRepository();
        LibraryService libraryService = LibraryService.createLibraryService(repository);

        repository.createConnection();
        //libraryService.addBook("Java is life", "Matheus", Year.of(2024));
        //libraryService.updateBook(7, "Até o verão terminar", "CoHo",  Year.of(2020));
        libraryService.getBooks();
        //libraryService.removeBook("To Kill a Mockingbird");
        repository.closeConnection();
    }
}
