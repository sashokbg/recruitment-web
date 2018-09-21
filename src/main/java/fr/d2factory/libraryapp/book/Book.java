package fr.d2factory.libraryapp.book;

/**
 * A simple representation of a book
 */
public class Book {
    String title;
    String author;
    ISBN isbn;

    public Book(String title, String author, ISBN isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
