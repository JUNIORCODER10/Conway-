import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Visualizer {

    private static int rows = 25; // Nombre de lignes par défaut
    private static int cols = 50; // Nombre de colonnes par défaut
    private static Grid grid; // La grille du jeu
    private static JPanel panel; // Le panneau pour afficher la grille
    private static Timer timer; // Timer pour gérer la simulation automatique
    private static int delay = 500; // Délai par défaut du Timer

    public static void visualize(Grid initialGrid) {
        grid = initialGrid;

        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Taille de la fenêtre

        JPanel contentPanel = new JPanel(new BorderLayout());

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int cellSize = 20; // Taille d'une cellule
                

                boolean[][] currentGrid = grid.getGrid();

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (currentGrid[row][col]) {
                            g.setColor(Color.gray); // Cellule vivante
                            g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                        } else {
                            g.setColor(Color.WHITE); // Cellule morte
                            g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                        }
                    }
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellSize = 20;
                int col = e.getX() / cellSize;
                int row = e.getY() / cellSize;
                grid.toggleCellState(row, col);
                panel.repaint();
            }
        });

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        JButton startButton = new JButton("Commencer");
        JButton stopButton = new JButton("Arreter");
        JButton clearButton = new JButton("Effacer");
        JButton slowerButton = new JButton("Ralentir");
        JButton fasterButton = new JButton("Accelerer");

        JTextField rowsField = new JTextField(5);
        rowsField.setText(String.valueOf(rows));
        JTextField colsField = new JTextField(5);
        colsField.setText(String.valueOf(cols));

        JButton resizeButton = new JButton("Redimensionner");

        buttonsPanel.add(new JLabel("Lignes: "));
        buttonsPanel.add(rowsField);
        buttonsPanel.add(new JLabel("Colonnes: "));
        buttonsPanel.add(colsField);
        buttonsPanel.add(resizeButton);
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(slowerButton);
        buttonsPanel.add(fasterButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopSimulation();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGrid();
                panel.repaint();
            }
        });

        slowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delay += 100; // Augmente le délai de 100 ms
                if (timer != null) {
                    timer.setDelay(delay);
                }
            }
        });

        fasterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (delay >= 100) { // Évite que le délai devienne négatif
                    delay -= 100; // Diminue le délai de 100 ms
                    if (timer != null) {
                        timer.setDelay(delay);
                    }
                }
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rows = Integer.parseInt(rowsField.getText());
                    cols = Integer.parseInt(colsField.getText());
                    Grid newGrid = new Grid(rows, cols);
                    grid = newGrid;
                    panel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer des nombres valides pour les lignes et les colonnes.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.add(buttonsPanel, BorderLayout.NORTH);

        frame.add(contentPanel);
        frame.setVisible(true);

        // Démarrer la simulation automatiquement au lancement du jeu
        initializeRandomGrid(); // Initialise la grille avec des cellules vivantes aléatoires
        startSimulation();
    }

    private static void startSimulation() {
        if (timer == null) {
            timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameLogic.calculateNextGeneration(grid);
                    panel.repaint(); // Redessiner la grille
                }
            });
            timer.start();
        }
    }

    private static void stopSimulation() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    private static void clearGrid() {
        grid = new Grid(rows, cols);
    }

    private static void initializeRandomGrid() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid.getGrid()[i][j] = random.nextBoolean();
            }
        }
    }

    public static void main(String[] args) {
        Grid initialGrid = new Grid(rows, cols);
        visualize(initialGrid);
    }
}