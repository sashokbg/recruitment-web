package com.entretien.services;

import com.entretien.entities.Book;
import com.entretien.entities.abstracts.Member;
import com.entretien.exceptions.HasLateBooksException;

import java.time.LocalDate;

/**
 * L'interface Library définit le contrat pour la gestion des opérations de bibliothèque, telles que
 * l'emprunt et le retour de livres.
 */
public interface Library {

    /**
     * Emprunte un livre de la bibliothèque pour un membre donné à une date spécifiée.
     *
     * @param isbnCode Le code ISBN du livre à emprunter.
     * @param member Le membre empruntant le livre.
     * @param borrowedAt La date à laquelle le livre est emprunté.
     * @return Le livre emprunté.
     * @throws HasLateBooksException Si le membre a des livres en retard et ne peut pas emprunter de nouveaux livres.
     */
    Book borrowBook(long isbnCode, Member member, LocalDate borrowedAt) throws HasLateBooksException;

    /**
     * Retourne un livre emprunté à la bibliothèque.
     *
     * @param book Le livre à retourner.
     * @param member Le membre retournant le livre.
     */
    void returnBook(Book book, Member member);
}
