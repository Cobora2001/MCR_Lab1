package main;

import gui.MainFrame;
import gui.GamePanel;
import shapes.Shape;
import shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Main Class handling the game logic and the simulation
 */
public class BouncerApp {
    private final int nbOfShapes = 50;
    private final int delay = 20;

    private final int maxAbsSpeed = 5;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;

    private static final LinkedList<Shape> bouncers = new LinkedList<>();

    /**
     * Constructor of the BouncerApp class
     * Initializes the bouncers and adds them to the GamePanel
     */
    public BouncerApp() {
        GamePanel.getInstance();

        Dimension dimension = GamePanel.getInstance().getPreferredSize();

        for (int i = 0; i < nbOfShapes; i++) {
            bouncers.add(ShapeFactory.createRandomShape(dimension.width,
                    dimension.height, maxAbsSpeed, minAbsSpeed, maxSize, minSize));
        }

        AddBouncersToGamePanel();
    }

    /**
     * Adds the bouncers to the GamePanel
     */
    private void AddBouncersToGamePanel() {
        GamePanel.getInstance().repaint();
    }


    /**
     * Starts the simulation of the bouncers
     */
    public void run(){
        Timer timer = new Timer(delay, e -> {
            for (Shape shape : bouncers) {
                shape.move(GamePanel.getInstance().getWidth(), GamePanel.getInstance().getHeight());
            }

            GamePanel.getInstance().repaint();
        });
        timer.start();
    }

    /**
     * @return the list of bouncers
     */
    public static LinkedList<Shape> getBouncers() {
        return bouncers;
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame.getInstance().setTitle("Bouncer App");
            new BouncerApp().run(); // Démarre le jeu après avoir affiché la fenêtre
        });
    }
}

