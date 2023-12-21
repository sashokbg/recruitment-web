package com.entretien.repositories;

import com.entretien.entities.Book;
import com.entretien.entities.abstracts.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IBookRepository {
     void addBooks(List<Book> books);

    /**
     * Recherche un livre dans le référentiel en utilisant son code ISBN.
     *
     * @param isbnCode Le code ISBN du livre à rechercher.
     * @return Le livre correspondant au code ISBN, ou null s'il n'est pas trouvé.
     */
     Book findBook(long isbnCode);


    /**
     * Recherche l'emprunteur d'un livre donné.
     *
     * @param book Le livre dont on recherche l'emprunteur.
     * @return Le membre qui a emprunté le livre, ou null s'il n'a pas été emprunté.
     */
    Member findBorrower(Book book);

    /**
     * Enregistre les détails d'emprunt d'un livre, en le retirant de la liste des livres disponibles
     * et en ajoutant ses détails d'emprunt.
     *
     * @param book Le livre emprunté.
     * @param borrowedAt La date à laquelle le livre a été emprunté.
     */
    void saveBookBorrow(Book book, LocalDate borrowedAt);

    /**
     * Enregistre l'emprunteur d'un livre donné.
     *
     * @param book Le livre emprunté.
     * @param member Le membre qui a emprunté le livre.
     */
     void saveBorrower(Book book, Member member);

    /**
     * Récupère la date d'emprunt d'un livre donné.
     *
     * @param book Le livre dont on recherche la date d'emprunt.
     * @return La date d'emprunt du livre, ou null s'il n'a pas été emprunté.
     */
     LocalDate findBorrowedBookDate(Book book);

    /**
     * Retourne un livre emprunté, le réintégrant dans la liste des livres disponibles.
     *
     * @param book Le livre à retourner.
     */
     void returnBook(Book book);

    /**
     * Récupère une carte des membres avec les listes des livres qu'ils ont empruntés.
     *
     * @return Une carte des membres et de leurs livres empruntés.
     */
     Map<Member, List<Book>> booksBorrowedByMember();
}
