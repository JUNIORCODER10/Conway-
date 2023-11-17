public class Grid {
    private boolean[][] grid;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];
    }

    public void setGrid(boolean[][] newGrid) {
        if (newGrid.length == rows && newGrid[0].length == cols) {
            this.grid = newGrid;
        } else {
            System.out.println("La nouvelle grille n'a pas la même taille que la grille actuelle.");
        }
    }

    public void randomizeGrid() {
        // Code pour initialiser la grille avec des valeurs aléatoires
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Math.random() > 0.5; // Cellule vivante ou morte aléatoirement
            }
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    public void displayGrid() {
        System.out.println("Generation:");
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print((cell ? "X" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void toggleCellState(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = !grid[row][col]; // Inverse l'état de la cellule
        }
    }
    public void setCellState(int row, int col, boolean state) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = state;
        }
    }
    
}
