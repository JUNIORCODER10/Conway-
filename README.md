# Jeu de la Vie de Conway
Le Jeu de la Vie de Conway est une simulation fascinante d'évolution cellulaire dans une grille en deux dimensions. Ce projet est une implémentation du jeu utilisant Java, permettant de visualiser et de contrôler la simulation.

Comment exécuter le jeu
Prérequis
Java Development Kit (JDK) installé
Étapes pour lancer le jeu
Téléchargez le code source du projet.
Ouvrez un terminal ou une invite de commande.
Naviguez jusqu'au répertoire contenant le code source.
Compilez les fichiers Java en utilisant la commande : javac *.java
Exécutez le jeu avec la commande : java GameOfLife
Fonctionnalités du jeu
Interface graphique interactive
Grille graphique : Affichage visuel d'une grille où chaque cellule peut être vivante (représentée par une couleur) ou morte (représentée par une couleur différente).
Interaction utilisateur : Possibilité d'interagir avec la grille en cliquant sur les cellules pour changer leur état (vivant/mort).
Contrôles de simulation
Démarrer / Arrêter la simulation : Boutons pour lancer ou arrêter la simulation des générations suivantes.
Effacer la grille : Bouton pour effacer la grille et réinitialiser toutes les cellules.
Accélérer / Ralentir la simulation : Options pour ajuster la vitesse de la simulation en accélérant ou en ralentissant le défilement des générations.
Redimensionnement de la grille
Redimensionner la grille : Possibilité de changer la taille de la grille en ajustant le nombre de lignes et de colonnes, offrant une expérience de jeu flexible.
Architecture du projet
GameLogic : Classe contenant la logique du jeu, incluant le calcul des générations suivantes selon les règles du Jeu de la Vie de Conway.
Grid : Gère la grille du jeu, permettant de remplir aléatoirement la grille, d'afficher l'état actuel, de modifier l'état des cellules, etc.
Visualizer : Fournit une interface graphique pour interagir avec le jeu, offrant des contrôles visuels et permettant de visualiser les changements de génération.
Implémentation
Le jeu utilise la logique du Jeu de la Vie de Conway pour déterminer l'évolution des cellules dans la grille. Chaque génération est calculée en fonction de l'état actuel des cellules et des règles définies par Conway.


Ce projet a été réalisé par Mohamed Gueye

Remarque
Ce README fournit une introduction détaillée au jeu. Pour explorer davantage les fonctionnalités, les classes, et la logique du jeu, veuillez consulter directement le code source.
