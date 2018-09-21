package fr.d2factory.libraryapp.member;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.library.Library;

public abstract class Member {
    public abstract void payBook(float price);

    void returnBook(Library library, Book book){
        //TODO call the library and implement the missing logic
    };

    void borrowBook(Library library, long isbn){
        //TODO call the library and implement the missing logic
    };

}
