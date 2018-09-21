package fr.d2factory.libraryapp.library.impl;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import fr.d2factory.libraryapp.library.Library;
import fr.d2factory.libraryapp.member.Member;

public class CityLibrary implements Library {
    private BookRepository bookRepository;

    public Book borrowBook(long isbnCode, Member member) {
        return null;
    }

    public void returnBook(Book book, Member member) {

    }
}
