package com.entretien.exceptions;

/**
 * La classe HasLateBooksException est une exception qui est levée lorsqu'un membre tente
 * d'emprunter un livre alors qu'il a des livres en retard.
 *
 * Cette exception étend RuntimeException, ce qui signifie qu'elle est une exception non vérifiée
 * et n'est pas nécessairement soumise à une déclaration dans la clause "throws" d'une méthode.
 *
 * Elle est utilisée pour signaler qu'un membre ne peut pas emprunter de nouveaux livres tant que
 * des livres en retard n'ont pas été retournés.
 */
public class HasLateBooksException extends RuntimeException {
    // Aucun ajout de méthode spécifique, car cette exception est principalement utilisée
    // pour signaler l'incapacité d'emprunter de nouveaux livres en raison de livres en retard.
}