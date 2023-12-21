package com.entretien.entities.abstracts;

import com.entretien.entities.enums.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * La classe abstraite Member représente un membre de la bibliothèque, avec des attributs tels que l'identifiant,
 * le prénom, le nom, le portefeuille, et la configuration de profil.
 * Elle fournit un constructeur pour initialiser les informations du membre, ainsi que des méthodes abstraites
 * pour effectuer le paiement des livres empruntés.
 */
@AllArgsConstructor
@Data
public abstract class Member {

    /** L'identifiant du membre. */
    private String id;

    /** Le prénom du membre. */
    private String firstName;

    /** Le nom de famille du membre. */
    private String lastName;

    /** Le montant d'argent disponible dans le portefeuille du membre. */
    private float wallet;

    /** La configuration de profil du membre. */
    private Profil config;

    /**
     * Constructeur de la classe abstraite Member.
     *
     * @param id L'identifiant du membre.
     * @param firstName Le prénom du membre.
     * @param lastName Le nom de famille du membre.
     * @param wallet Le montant d'argent dans le portefeuille du membre.
     * @param config La configuration de profil du membre.
     */


    /**
     * Méthode abstraite pour effectuer le paiement des livres empruntés.
     *
     * @param numberOfDays Le nombre de jours pendant lesquels les livres ont été empruntés.
     */
    public abstract void payBook(int numberOfDays);
}

