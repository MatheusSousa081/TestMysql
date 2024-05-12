package org.devJava.service;

import org.devJava.book.Book;
import org.devJava.repository.BookRepository;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.time.Year;

public class LibraryService {
    private BookRepository repository;

    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public static LibraryService createLibraryService(@NotNull BookRepository bookRepository) {
        return new LibraryService(bookRepository);
    }

    public void addBook(@NotNull String title,@NotNull String author,@NotNull Year year)throws SQLException {
        repository.registerBook(title, author, year);
    }

    public void getBooks() throws SQLException{
        repository.showBooks();
    }

    public void removeBook(@NotNull String title) throws SQLException{
        repository.removeBook(title);
    }

    public void updateBook(@NotNull int id, @NotNull String newTitle, @NotNull String newAuthor, @NotNull Year newYear) throws SQLException{
        repository.updateBook(id, newTitle, newAuthor, newYear);
    }
}
