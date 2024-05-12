package org.devJava.repository;

import org.devJava.book.Book;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.Year;

public class BookRepository {
    private final String url = "jdbc:mysql://localhost:3306/teste-java";
    private final String user = "matheus";
    private final String password = "0511";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void showInfo() throws SQLException {
        System.out.println(connection.getClientInfo());

    }

    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the database");

    }

    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println("Connection closed");

    }

    public void registerBook(@NotNull String title, @NotNull String author, @NotNull Year year) throws SQLException {
        String query = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setInt(3, year.getValue());
        preparedStatement.executeUpdate();
        System.out.println("Book added successfully");
    }

    public void showBooks() throws SQLException {
        String query = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println((resultSet.getInt("id") + " - " +
                    resultSet.getString("title") + " by " +
                    resultSet.getString("author") + " (" +
                    resultSet.getInt("year") + ")"));
        }
    }

    public void removeBook(@NotNull String title) throws SQLException {
        String query = "DELETE FROM books WHERE title=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.executeUpdate();
        System.out.println("Book removed successfully");
    }

    public void updateBook(@NotNull int id, @NotNull String newTitle, String newAuthor, Year year) throws SQLException {
        String query = "UPDATE books SET title=?, author=?, year=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newTitle);
        preparedStatement.setString(2, newAuthor);
        preparedStatement.setInt(3, year.getValue());
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
        System.out.println("Book updated successfully");
    }
}
