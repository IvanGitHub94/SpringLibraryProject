package com.jpcsaturday.SpringLibraryProject.dbexample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDaoJDBC_1 {
    public Book findBookById(Integer bookId) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/local_db",
                "postgres",
                "12345")
        ) {
            if (connection != null) {
                System.out.println("Ура! Мы подключились к базе данных!");
            } else {
                System.out.println("БД недоступна!");
            }


        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }
}
