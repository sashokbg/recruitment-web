package com.entretien.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * L'énumération Profil représente les différents profils de membres de la bibliothèque,
 * chacun avec ses propres paramètres tels que la période maximale d'emprunt, la période gratuite,
 * le montant facturé avant et après la période gratuite.
 */
@AllArgsConstructor
@Getter
public enum Profil {

    /** Profil pour les résidents. */
    RESIDENT(60, 0, 0.10f, 0.20f),

    /** Profil pour les étudiants. */
    STUDENT(30, 0, 0.10f, 0.10f),

    /** Profil pour les étudiants de première année. */
    STUDENT_1ST_YEAR(30, 15, 0.10f, 0.10f);

    /** La période maximale d'emprunt pour ce profil. */
    private final int maxPeriod;

    /** La période gratuite avant que des frais ne soient facturés. */
    private final int freePeriod;

    /** Le montant facturé avant la période gratuite. */
    private final float amountChargedBefore;

    /** Le montant facturé après la période gratuite. */
    private final float amountChargedAfter;

}
