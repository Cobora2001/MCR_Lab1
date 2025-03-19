// Authors: Thomas Vuilleumier, Sebastian Diaz

package apps;

import gui.GamePanel;
import gui.MainFrame;
import movement.BouncingMovement;
import shapes.Bouncable;
import shapes.factory.CircleFactory;
import shapes.factory.ModelFactory;
import shapes.factory.SquareFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Main Class handling the game logic and the simulation.
 */
public class BouncerApp implements App {
    // Constants
    private final int delay = 20;
    private final int maxAbsSpeed = 10;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;
    private final int nbPerGeneration = 10;

    // List of bouncers
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    // List of factories
    private final Vector<ModelFactory> factories = new Vector<>();

    // Constructor
    public BouncerApp() {
        MainFrame.getInstance().setTitle("Bouncer App");

        // Add factories
        addFactory(CircleFactory.getInstance());
        addFactory(SquareFactory.getInstance());

        // Add a key listener to the main frame
        MainFrame.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                treatKeySignal(e);
            }
        });
    }

    /**
     * Main method of the application.
     */
    @Override
    public void run() {
        Timer timer = new Timer(delay, e -> updateFrame());
        timer.start();
    }

    /**
     * Updates the frame.
     */
    private void updateFrame() {
        // Retrieve the buffered image of GamePanel
        BufferedImage buffer = GamePanel.getInstance().getBufferImage();
        Graphics2D g2 = buffer.createGraphics();

        // Clear the buffered image to avoid ghosting from previous images
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

        // Move objects before drawing them
        for (Bouncable b : bouncers) {
            b.move();
        }

        // Draw objects
        draw();

        // Dispose the graphics context
        g2.dispose();

        // Refresh the GamePanel display
        GamePanel.getInstance().refresh();
    }

    /**
     * Draws specific elements from the App on a Graphics object.
     */
    @Override
    public void draw() {
        for (Bouncable bouncable : bouncers) {
            bouncable.draw();
        }
    }

    /**
     * Removes all bouncers from the list.
     */
    private void clearBouncers() {
        bouncers.clear();
    }

    /**
     * Quits the application.
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Processes key events.
     * @param e the key event.
     */
    @Override
    public void treatKeySignal(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_E -> {
                System.out.println("Clear bouncers");
                clearBouncers();
            }
            case KeyEvent.VK_F -> {
                System.out.println("Add full models");
                generateFullModel();
            }
            case KeyEvent.VK_B -> {
                System.out.println("Add border models");
                generateBorderModel();
            }
            case KeyEvent.VK_Q -> {
                System.out.println("Quit");
                quit();
            }
            default -> System.out.println("This key is not handled");
        }
    }

    /**
     * Adds a factory to the list of factories.
     * @param factory the factory to add.
     */
    public void addFactory(ModelFactory factory) {
        factories.add(factory);
    }

    /**
     * Generates full models.
     */
    private void generateFullModel() {
        for (ModelFactory factory : factories) {
            for (int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createFullModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    /**
     * Generates border models.
     */
    private void generateBorderModel() {
        for (ModelFactory factory : factories) {
            for (int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createBorderModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    /**
     * Returns the list of bouncers.
     * @return the list of bouncers.
     */
    public LinkedList<Bouncable> getBouncers() {
        return bouncers;
    }

    /**
     * Main method.
     * @param args the arguments.
     */
    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> new BouncerApp().run());
    }
}
