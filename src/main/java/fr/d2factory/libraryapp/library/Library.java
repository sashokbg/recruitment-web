package fr.d2factory.libraryapp.library;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.member.Member;

public interface Library {

    Book borrowBook(long isbnCode, Member member);

    /**
     * A member returns a book to the library.
     * We should calculate the tarif and probably charge them
     * @param book the {@link Book} they return
     * @param member the {@link Member} who is returning the book
     *
     * @see Member#payBook(float)
     */
    void returnBook(Book book, Member member);
}
