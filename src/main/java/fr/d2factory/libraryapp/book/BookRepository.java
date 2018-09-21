package fr.d2factory.libraryapp.book;

import java.util.HashMap;
import java.util.Map;

/**
 * The book repository emulates a database via 2 HashMaps
 */
public class BookRepository {
    private Map<ISBN, Book> availableBooks = new HashMap<>();
    private Map<ISBN, Book> borrowedBooks = new HashMap<>();
}
