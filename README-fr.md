# Exercise de Recruitment Java

L'exercise suivant a pour objectif de mettre à l'épreuve vos compétences de conception et de résolution
de problèmes du monde réel.

Le but de l'exercise est de développer une application de gestion de livres empruntés pour une
bibliothèque fictive (utilisant Java 8 ou plus récent) en respectant les règles métier détaillées 
ci-dessous:

### Règles métier

```text
    La ville de Tonwsville a besoin d'un nouveau système de gestion des livres empruntés
    pour sa bibliothèque afin de remplacer la vieille méthodologie de travail et 
    de réduire la paperasse.
    
    La bibliothèque a comme adhérents deux groupes de personnes - les étudiants et les riverains.
    Seuls des adhérent peuvent emprunter des livres à la bibliothèque
    
    Tarifs et délais d'emprunt d'un livre:
    
    Le tarif étudiant est de 10 centimes par jour (0.10 eu) pour les 30 premiers jours.
    Seul exception sont les étudiants en première année qui bénéficient d'une période
    gratuite de 15 jours pour chaque livre emprunté.
    
    Un tarif élevé de 15 centimes par jour (0.15 eu) est appliqué à tous les étudiants
    au-delà les premiers 30 jours et on considère l'étudiant "en retard". 
    Cette règle s'applique également aux étudiants en première année.
    
    Le tarif riverain est de 10 centimes par jour (0.10 eu) pour les 60 premiers jours.
    Au-delà de cette période on considère le riverain "en retard" et un tarif élevé de 
    20 centimes par jour (0.20 eu) est appliqué.
    
    Si un adhérent (riverain ou étudiant) est en retard, il ne peut pas emprunter
    de nouveaux livres avant de retourner les précédents.
```

### Exigences

* Le temps:

Vous disposez d'autant de temps que vous désirez, mais en général l'exercise ne devrait pas vous prendre plus
qu'un après-midi.

* Solution

Votre solution devrai compiler proprement et tous les tests unitaires dans la class LibraryTest devront passer au vert.

* Comment envoyer la solution

Vous pouvez faire un fork du repository GitHub et nous envoyer le lien de votre repository.

https://github.com/DevoteamDigitalFactory/recruitment-web

Si vous n'utilisez pas GitHub, vous pouvez également nous communiquer la solution par e-mail.


### Hints

Vous devez :

* Implémenter la logique métier demandée 
* Implémenter les tests unitaires dans le fichier src/test/LibraryTest.java
* Corriger ou améliorer le code existant si vous trouver qu'il est mal écrit ou ne respecte pas les convention Java
* Utiliser des APIs Java modernes si possible
* Éviter les frameworks lourds comme Spring
* Faire attention aux pièges dans le code
* Ne perdez pas de temps à implémenter des codes ISBN. Ils sont fictifs et ne servent qu'à identifier les livres.
* Vous amusez :)


Vous pouvez :

* Changer le code existant, en suivant plus au moins la structure initiale proposée
* Ajouter de nouveau code et fonctionnalité à votre guise
* Ajouter de nouveaux tests unitaires si ça vous paraît logique
* Se servir de design patterns pour résoudre certains problèmes

Happy Coding :) !