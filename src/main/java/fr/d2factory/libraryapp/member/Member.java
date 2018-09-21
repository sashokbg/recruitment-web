package fr.d2factory.libraryapp.member;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.library.Library;

/**
 * A member is a person who can borrow and return books to a {@link Library}
 * A member can be either a student or a resident
 */
public abstract class Member {
    /**
     * An initial sum of money the member has
     */
    private float wallet;

    /**
     * The member should pay their books when they are returned to the library
     *
     * @param price the price for the borrowed time
     */
    public abstract void payBook(float price);

    void returnBook(Library library, Book book){
        //TODO call the library and implement the missing logic
    };

    void borrowBook(Library library, long isbn){
        //TODO call the library and implement the missing logic
    };

}
