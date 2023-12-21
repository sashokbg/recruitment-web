package com.entretien.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * La classe ISBN représente un numéro ISBN (International Standard Book Number) associé à un livre.
 * Elle stocke le code ISBN sous forme de long.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ISBN {
    /** Le code ISBN sous forme de long. */
    long isbnCode;
}
