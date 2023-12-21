package com.entretien.entities;


import com.entretien.entities.abstracts.Member;
import com.entretien.entities.enums.Profil;
import com.entretien.exceptions.NoEnoughFundInTheWallet;

/**
 * La classe StudentMember est une sous-classe de Member qui représente un membre étudiant de la bibliothèque.
 * Elle hérite des attributs et méthodes de la classe Member et fournit une implémentation spécifique de la méthode
 * abstraite payBook pour gérer le paiement des livres empruntés par un membre étudiant.
 */

public class StudentMember extends Member {
    /**
     * Constructeur de la classe StudentMember.
     *
     * @param id L'identifiant du membre étudiant.
     * @param firstName Le prénom du membre étudiant.
     * @param lastName Le nom de famille du membre étudiant.
     * @param wallet Le montant d'argent dans le portefeuille du membre étudiant.
     * @param config La configuration de profil du membre étudiant.
     */
    public StudentMember(String id, String firstName, String lastName, float wallet, Profil config) {
        super(id, firstName, lastName, wallet, config);
    }

    /**
     * {@inheritDoc}
     *
     * Implémentation spécifique de la méthode abstraite payBook pour les membres étudiants.
     * Calcule le montant à payer pour les livres empruntés en fonction du nombre de jours
     * après la période gratuite et déduit ce montant du portefeuille du membre étudiant.
     *
     * @param numberOfDays Le nombre de jours pendant lesquels les livres ont été empruntés.
     * @throws NoEnoughFundInTheWallet Si le portefeuille du membre étudiant ne contient pas suffisamment de fonds.
     */
    @Override
    public void payBook(int numberOfDays) {
        float amountToPay = Math.max(0, numberOfDays - getConfig().getFreePeriod()) * getConfig().getAmountChargedBefore();
        if (amountToPay < getWallet()) {
            setWallet(getWallet() - amountToPay);
        } else {
            throw new NoEnoughFundInTheWallet();
        }
    }
}

