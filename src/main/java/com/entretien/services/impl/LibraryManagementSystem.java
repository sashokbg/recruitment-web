package com.entretien.services.impl;

import com.entretien.entities.Book;
import com.entretien.entities.abstracts.Member;
import com.entretien.exceptions.HasLateBooksException;
import com.entretien.repositories.IBookRepository;
import com.entretien.services.Library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * La classe LibraryManagementSystem implémente l'interface Library et gère les opérations de la bibliothèque,
 * telles que l'emprunt et le retour de livres. Elle utilise un BookRepository pour stocker et récupérer les informations
 * sur les livres disponibles et empruntés.
 */

public class LibraryManagementSystem implements Library {

    /** Le référentiel de livres utilisé par le système de gestion de bibliothèque. */
    private final IBookRepository bookRepository;

    /**
     * Constructeur de la classe LibraryManagementSystem.
     *
     * @param bookRepository Le référentiel de livres à utiliser par le système.
     */
    public LibraryManagementSystem(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book borrowBook(long isbnCode, Member member, LocalDate borrowedAt) {
        if (isLate(member)) {
            throw new HasLateBooksException();
        }

        Optional<Book> opBook = Optional.ofNullable(bookRepository.findBook(isbnCode));
        opBook.ifPresent(book -> {
            bookRepository.saveBookBorrow(book, borrowedAt);
            bookRepository.saveBorrower(book, member);
        });

        return opBook.orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void returnBook(Book book, Member member) {
        int numberOfDays = (int) bookRepository.findBorrowedBookDate(book).until(LocalDate.now(), ChronoUnit.DAYS);
        bookRepository.returnBook(book);
        member.payBook(numberOfDays);
    }

    /**
     * Vérifie si un membre a des livres en retard.
     *
     * @param member Le membre à vérifier.
     * @return true si le membre a des livres en retard, false sinon.
     */
    private boolean isLate(Member member) {
        return Optional.ofNullable(bookRepository.booksBorrowedByMember().get(member))
                .map(books -> books.stream()
                        .anyMatch(b -> bookNotReturned(b, member.getConfig().getMaxPeriod())))
                .orElse(false);
    }


    /**
     * Vérifie si un livre n'a pas été retourné dans la période spécifiée.
     *
     * @param book     Le livre à vérifier.
     * @param maxPeriod La période maximale avant qu'un livre ne soit considéré comme en retard.
     * @return true si le livre n'a pas été retourné dans la période spécifiée, false sinon.
     */
    private boolean bookNotReturned(Book book, int maxPeriod) {
        return daysBorrowed(book) > maxPeriod;
    }


    /**
     * Calcule le nombre de jours pendant lesquels un livre a été emprunté.
     *
     * @param book Le livre dont on veut calculer la durée d'emprunt.
     * @return Le nombre de jours d'emprunt du livre.
     */
    private int daysBorrowed(Book book) {
        return (int) bookRepository.findBorrowedBookDate(book).until(LocalDate.now(), ChronoUnit.DAYS);
    }

}

