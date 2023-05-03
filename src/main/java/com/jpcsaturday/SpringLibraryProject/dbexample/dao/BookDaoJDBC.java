package com.jpcsaturday.SpringLibraryProject.dbexample.dao;

import com.jpcsaturday.SpringLibraryProject.dbexample.db.DBConnection;
import com.jpcsaturday.SpringLibraryProject.dbexample.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoJDBC {
    public Book findBookById(Integer bookId) {
        try (Connection connection = DBConnection.INSTANCE.getConnection()) {
            if (connection != null) {
                System.out.println("Ура! Мы подключились к базе данных!");
            } else {
                System.out.println("БД недоступна!");
            }

            String select = "select * from books where id = ?";

            assert connection != null;
            PreparedStatement selectQuery = connection.prepareStatement(select);
            selectQuery.setInt(1, bookId);
            ResultSet resultSet = selectQuery.executeQuery();

            Book book = new Book();
//            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
//                book.setId(resultSet.getInt(1));
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDateAdded(resultSet.getDate("date_added"));
//                books.add(book);
                System.out.println(book);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public Book findBookByTitle() {
        return null;
    }
}

