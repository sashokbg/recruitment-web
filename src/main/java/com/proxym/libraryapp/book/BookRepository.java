package com.proxym.libraryapp.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The book repository emulates a database via 2 HashMaps
 */
public class BookRepository {
    private Map<ISBN, Book> availableBooks = new HashMap<>();

    public void saveAll(List<Book> books){
        //TODO implement the missing feature
    }

    public void save(Book book){
        //TODO implement the missing feature
    }

    public Book findBook(long isbnCode) {
        //TODO implement the missing feature
        return null;
    }
}
