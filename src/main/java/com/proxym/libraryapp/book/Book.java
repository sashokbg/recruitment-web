package com.proxym.libraryapp.book;

import java.time.LocalDate;

/**
 * A simple representation of a book
 */
public class Book {
    String title;
    String author;
    ISBN isbn;
    LocalDate borrowedAt;

    public Book() {}
}
