package com.entretien.entities;


import com.entretien.entities.abstracts.Member;
import com.entretien.entities.enums.Profil;
import com.entretien.exceptions.NoEnoughFundInTheWallet;

/**
 * La classe ResidentMember est une sous-classe de Member qui représente un membre résident de la bibliothèque.
 * Elle hérite des attributs et méthodes de la classe Member et fournit une implémentation spécifique de la méthode
 * abstraite payBook pour gérer le paiement des livres empruntés par un membre résident.
 */
public class ResidentMember extends Member {
    public ResidentMember(String id, String firstName, String lastName, float wallet, Profil config) {
        super(id, firstName, lastName, wallet, config);
    }


    /**
     * Constructeur de la classe ResidentMember.
     *
     * @param id L'identifiant du membre résident.
     * @param firstName Le prénom du membre résident.
     * @param lastName Le nom de famille du membre résident.
     * @param wallet Le montant d'argent dans le portefeuille du membre résident.
     * @param config La configuration de profil du membre résident.
     */

    /**
     * {@inheritDoc}
     *
     * Implémentation spécifique de la méthode abstraite payBook pour les membres résidents.
     * Calcule le montant à payer pour les livres empruntés en fonction du nombre de jours
     * et déduit ce montant du portefeuille du membre résident.
     *
     * @param numberOfDays Le nombre de jours pendant lesquels les livres ont été empruntés.
     * @throws NoEnoughFundInTheWallet Si le portefeuille du membre résident ne contient pas suffisamment de fonds.
     */
    @Override
    public void payBook(int numberOfDays) {
        int maxPeriod = getConfig().getMaxPeriod();
        float amountToPay = Math.min(maxPeriod, numberOfDays) * getConfig().getAmountChargedBefore()
                + Math.max(0, numberOfDays - maxPeriod) * getConfig().getAmountChargedAfter();
        if (amountToPay < getWallet()) {
            setWallet(getWallet() - amountToPay);
        } else {
            throw new NoEnoughFundInTheWallet();
        }
    }
}

