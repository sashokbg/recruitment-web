package com.entretien.repositories.impl;


import com.entretien.entities.Book;
import com.entretien.entities.ISBN;
import com.entretien.entities.abstracts.Member;
import com.entretien.exceptions.BookNotFoundException;
import com.entretien.exceptions.HasLateBooksException;
import com.entretien.repositories.IBookRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * La classe BookRepository représente un référentiel de livres, gérant les livres disponibles, empruntés
 * et les détails des emprunteurs. Elle offre des méthodes pour ajouter des livres, rechercher des livres par ISBN,
 * trouver des emprunteurs, enregistrer les détails d'emprunt, enregistrer les emprunteurs, récupérer la date d'emprunt,
 * retourner un livre, et obtenir une carte des membres avec les livres qu'ils ont empruntés.
 */
public class BookRepository implements IBookRepository {
    /** Les livres disponibles avec leur ISBN associé. */
    private Map<ISBN, Book> availableBooks;

    /** Les livres empruntés avec la date d'emprunt associée. */
    private Map<Book, LocalDate> borrowedBooks;

    /** Les emprunteurs associés à chaque livre emprunté. */
    private Map<Book, Member> borrower;


     public BookRepository(){
         availableBooks = new HashMap<>();
         borrowedBooks = new HashMap<>();
         borrower = new HashMap<>();
     }

    /**
     * Ajoute une liste de livres au référentiel, en s'assurant qu'ils ne sont pas déjà présents.
     *
     * @param books La liste des livres à ajouter.
     */
    public void addBooks(List<Book> books) {
        books.stream()
                .filter(book -> !availableBooks.containsKey(book.getIsbn()))
                .forEach(book -> availableBooks.put(book.getIsbn(), book));
    }

    /**
     * Recherche un livre dans le référentiel en utilisant son code ISBN.
     *
     * @param isbnCode Le code ISBN du livre à rechercher.
     * @return Le livre correspondant au code ISBN, ou null s'il n'est pas trouvé.
     */
    public Book findBook(long isbnCode) {
        return availableBooks.computeIfAbsent(new ISBN(isbnCode), isbn -> {
            throw new HasLateBooksException();
        });
    }

    /**
     * Recherche l'emprunteur d'un livre donné.
     *
     * @param book Le livre dont on recherche l'emprunteur.
     * @return Le membre qui a emprunté le livre, ou null s'il n'a pas été emprunté.
     */
    public Member findBorrower(Book book) {
        return borrower.get(book);
    }

    /**
     * Enregistre les détails d'emprunt d'un livre, en le retirant de la liste des livres disponibles
     * et en ajoutant ses détails d'emprunt.
     *
     * @param book Le livre emprunté.
     * @param borrowedAt La date à laquelle le livre a été emprunté.
     */
    public void saveBookBorrow(Book book, LocalDate borrowedAt) {
        availableBooks.remove(book.getIsbn());
        borrowedBooks.put(book, borrowedAt);
    }

    /**
     * Enregistre l'emprunteur d'un livre donné.
     *
     * @param book Le livre emprunté.
     * @param member Le membre qui a emprunté le livre.
     */
    public void saveBorrower(Book book, Member member) {
        borrower.put(book, member);
    }

    /**
     * Récupère la date d'emprunt d'un livre donné.
     *
     * @param book Le livre dont on recherche la date d'emprunt.
     * @return La date d'emprunt du livre, ou null s'il n'a pas été emprunté.
     */
    public LocalDate findBorrowedBookDate(Book book) {
        return borrowedBooks.get(book);
    }

    /**
     * Retourne un livre emprunté, le réintégrant dans la liste des livres disponibles.
     *
     * @param book Le livre à retourner.
     */
    public void returnBook(Book book) {
        if (book != null) {
            borrowedBooks.remove(book);
            availableBooks.put(book.getIsbn(), book);
            borrower.remove(book);
        } else {
            throw new BookNotFoundException();
        }
    }

    /**
     * Récupère une carte des membres avec les listes des livres qu'ils ont empruntés.
     *
     * @return Une carte des membres et de leurs livres empruntés.
     */
    public Map<Member, List<Book>> booksBorrowedByMember() {
        return borrower.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }
}