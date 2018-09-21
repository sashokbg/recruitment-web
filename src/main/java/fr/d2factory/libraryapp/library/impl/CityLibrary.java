package fr.d2factory.libraryapp.library.impl;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import fr.d2factory.libraryapp.library.Library;
import fr.d2factory.libraryapp.member.Member;

public class CityLibrary implements Library {
    private BookRepository bookRepository;
    private String name;

    public CityLibrary(BookRepository bookRepository, String name) {
        this.bookRepository = bookRepository;
        this.name = name;
    }

    public Book borrowBook(long isbnCode, Member member) {
        return null;
    }

    @Override
    public void returnBook(Book book, Member member) {

    }
}
