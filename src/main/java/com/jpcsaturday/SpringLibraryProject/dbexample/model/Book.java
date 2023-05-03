package com.jpcsaturday.SpringLibraryProject.dbexample.model;

import lombok.*;
import java.util.Date;

// POJO - Plain Old Java Object
@Getter
@Setter
@ToString
//@Data
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Date dateAdded;

    public Book(Integer id, String title, String author, Date dateAdded) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateAdded = dateAdded;
    }

    public Book() {
    }
}

