public class GameOfLife {

    public static void main(String[] args) {
        int rows = 10;
        int cols = 10; 
        int numberOfGenerations = 5; 

        Grid grid = new Grid(rows, cols); 
        grid.randomizeGrid(); // Remplir la grille de manière aléatoire

        // Afficher la grille initiale
        grid.displayGrid();

        // Boucle pour les générations successives
        for (int generation = 1; generation <= numberOfGenerations; generation++) {
            GameLogic.calculateNextGeneration(grid); // Calcul de la prochaine génération depuis GameLogic
            grid.displayGrid(); // Afficher la grille après la génération
            
        }
    }
}