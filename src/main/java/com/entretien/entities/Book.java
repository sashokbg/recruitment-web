package com.entretien.entities;

import lombok.*;

/**
 * La classe Book représente un livre avec des attributs tels que le titre, l'auteur et l'ISBN.
 * Elle fournit des méthodes pour accéder à ces informations, ainsi que des méthodes pour la comparaison,
 * la représentation sous forme de chaîne et la génération du code de hachage.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    /** Le titre du livre. */
    String title;

    /** L'auteur du livre. */
    String author;

    /** L'ISBN (International Standard Book Number) du livre. */
    ISBN isbn;

 }
