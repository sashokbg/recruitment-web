package fr.d2factory.libraryapp.book;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<ISBN, Book> availableBooks = new HashMap<>();
    private Map<ISBN, Book> borrowedBooks = new HashMap<>();

}
