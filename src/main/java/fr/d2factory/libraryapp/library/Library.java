package fr.d2factory.libraryapp.library;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.member.Member;

public interface Library {

    /**
     * A member is borrowing a book in our library.
     *
     * @param isbnCode the isbn code of the book
     * @param member the member who is borrowing the book
     * @return the book the member wishes to obtain if found
     * @throws HasLateBooksException in case the member has books that are late
     *
     * @see fr.d2factory.libraryapp.book.ISBN
     * @see Member
     */
    Book borrowBook(long isbnCode, Member member) throws HasLateBooksException;

    /**
     * A member returns a book to the library.
     * We should calculate the tarif and probably charge them
     *
     * @param book the {@link Book} they return
     * @param member the {@link Member} who is returning the book
     *
     * @see Member#payBook(float)
     */
    void returnBook(Book book, Member member);
}
