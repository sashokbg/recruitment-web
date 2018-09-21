package fr.d2factory.libraryapp.library;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.member.Member;

public interface Library {
    Book borrowBook(long isbnCode, Member member);
    void returnBook(Book book, Member member);
}
