public class GameLogic {

    public static void calculateNextGeneration(Grid grid) {
        int rows = grid.getRows();
        int cols = grid.getCols();
        boolean[][] currentGrid = grid.getGrid();
        boolean[][] nextGeneration = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(currentGrid, row, col, rows, cols);

                // Règles du Jeu de la Vie de Conway
                if (currentGrid[row][col]) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[row][col] = false;
                    } else {
                        nextGeneration[row][col] = true;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[row][col] = true;
                    }
                }
            }
        }

        grid.setGrid(nextGeneration);
    }

    private static int countLiveNeighbors(boolean[][] grid, int row, int col, int rows, int cols) {
        int count = 0;
        int[] neighbors = {-1, 0, 1};

        for (int i : neighbors) {
            for (int j : neighbors) {
                if (!(i == 0 && j == 0)) {
                    int neighborRow = row + i;
                    int neighborCol = col + j;

                    if (isValidCell(neighborRow, neighborCol, rows, cols) && grid[neighborRow][neighborCol]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}