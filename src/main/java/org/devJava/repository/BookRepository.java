package org.devJava.repository;

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

    public void showInfo() throws SQLException{
        try {
            System.out.println(connection.getClientInfo());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Error in connect to the database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error in close the connection: " + e.getMessage());
        }
    }

    public void registerBook(@NotNull String title,@NotNull String author,@NotNull Year year) {
        String query = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, year.getValue());
            preparedStatement.executeUpdate();
            System.out.println("Book added successfully");
        } catch (SQLException e) {
            System.out.println("Failed to add the book: " + e.getMessage());
        }
    }

    public void showBooks() {
        String query = "SELECT * FROM books";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println((resultSet.getInt("id") + " - " +
                        resultSet.getString("title") + " by " +
                        resultSet.getString("author") + " (" +
                        resultSet.getInt("year") + ")"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to show books:" + e.getMessage());
        }
    }
}
