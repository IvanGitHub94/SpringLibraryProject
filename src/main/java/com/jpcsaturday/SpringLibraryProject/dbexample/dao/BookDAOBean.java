package com.jpcsaturday.SpringLibraryProject.dbexample.dao;

import com.jpcsaturday.SpringLibraryProject.dbexample.model.Book;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookDAOBean {
    private final Connection connection;

    private final String SELECT_BOOK_BY_ID_QUERY = "select * from books where id = ?";

    public BookDAOBean(Connection connection) {
        this.connection = connection;
    }

    public Book findBookById(Integer bookId) throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(SELECT_BOOK_BY_ID_QUERY);
        selectQuery.setInt(1, bookId);
        ResultSet resultSet = selectQuery.executeQuery();
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setDateAdded(resultSet.getDate("date_added"));
            System.out.println(book);
        }
        return book;
    }
}
