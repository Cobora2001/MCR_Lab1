// Authors: Thomas Vuilleumier, Sebastian Diaz

package apps;

import gui.GamePanel;
import gui.MainFrame;
import movement.BouncingMovement;
import movement.FieldDimensions;
import shapes.Bouncable;
import shapes.factory.CircleFactory;
import shapes.factory.ModelFactory;
import shapes.factory.SquareFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Main Class handling the game logic and the simulation
 */
public class BouncerApp implements App {
    // Delay between each frame
    private final int delay = 20;

    // Constants for the generation of the models
    private final int maxAbsSpeed = 10;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;

    // Number of models generated per generation per factory
    private final int nbPerGeneration = 10;

    // List of bouncers
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();

    // Vector of factories
    private final Vector<ModelFactory> factories = new Vector<>();

    /**
     * Constructor of the BouncerApp class
     * Initializes the bouncers and adds them to the MainFrame
     */
    public BouncerApp() {
        MainFrame.getInstance().setTitle("Bouncer App");

        // We create a FieldDimensions object with the dimensions of the initial GamePanel via the MainFrame
        Dimension dimension = MainFrame.getInstance().getPreferredSize();
        FieldDimensions fieldDimensions = new FieldDimensions(0, 0, dimension.width, dimension.height);

        // We set the dimensions of the GamePanel via the MainFrame to the FieldDimensions object
        MainFrame.getInstance().setFieldDimensions(fieldDimensions);
        addFactory(CircleFactory.getInstance());

        // We set the dimensions of the CircleFactory to the FieldDimensions object
        CircleFactory.getInstance().setFieldDimensions(fieldDimensions);
        addFactory(SquareFactory.getInstance());

        // We set the dimensions of the SquareFactory to the FieldDimensions object
        SquareFactory.getInstance().setFieldDimensions(fieldDimensions);
        BouncingMovement.getInstance().setDimensions(fieldDimensions);

        // We add a KeyListener to the MainFrame
        MainFrame.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                treatKeySignal(e);
            }
        });
    }

    /**
     * Starts the simulation of the bouncers
     * Small note: We have tried multiple ways to run the simulation, but none of them were perfect
     * This was discussed in class with both the teacher and the assistant, and no solution was found
     */
    public void run(){
        // Version with a Timer to allow the use of the KeyListener
        // Issue: The models flicker
        Timer timer = new Timer(delay, e -> {
            Graphics2D g = GamePanel.getInstance().getGraphics();
            if (g != null) {
                for (Bouncable bouncable : bouncers) {
                    bouncable.move();
                }

                draw();
                GamePanel.getInstance().repaint();
            }
        });

        timer.start(); // Start the timer

        // Version with a while infinite loop to prevent flickering of the models
        // Issue: We can't use the KeyListener to interact with the models

        // given that in this version, the KeyListener doesn't work, we manually add full models
        /*
        generateFullModel();
        Graphics2D g = GamePanel.getInstance().getGraphics();
        while(true) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 600); // hard-coded for tests only
            for (Bouncable bouncable : bouncers) {
                bouncable.move();
            }
            draw();
            MainFrame.getInstance().repaint();
            // make the thread sleep for a short time
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */

        // Version with a Thread to allow the use of the KeyListener
        // Issue: The models flicker
        /*
        new Thread(() -> {
            generateFullModel();
            Graphics2D g = GamePanel.getInstance().getGraphics();
            while (true) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 800, 600); // hard-coded for tests only

                for (Bouncable bouncable : bouncers) {
                    bouncable.move();
                }

                SwingUtilities.invokeLater(() -> {
                    draw();
                    MainFrame.getInstance().repaint();
                });

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        */
    }

    /**
     * Clears the list of bouncers
     */
    private void clearBouncers() {
        bouncers.clear();
    }

    /**
     * Quits the application
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Is used to draw specific elements from the App on a Graphics object
     */
    @Override
    public void draw() {
        Graphics2D g = GamePanel.getInstance().getGraphics();
        if(g == null) {
            return;
        }
        for(Bouncable bouncable : bouncers) {
            bouncable.draw();
        }
    }

    /**
     * Is used to treat a KeyEvent
     * @param e the KeyEvent to be treated
     */
    @Override
    public void treatKeySignal(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_E:
                System.out.println("Clear bouncers");
                clearBouncers();
                break;
            case KeyEvent.VK_F:
                System.out.println("Add full models");
                generateFullModel();
                break;
            case KeyEvent.VK_B:
                System.out.println("Add border models");
                generateBorderModel();
                break;
            case KeyEvent.VK_Q:
                System.out.println("Quit");
                quit();
                break;
            default:
                System.out.println("This key is not handled");
                break;
        }
    }

    /**
     * Adds a factory to the list of factories
     * @param factory the factory to be added
     */
    public void addFactory(ModelFactory factory) {
        factories.add(factory);
    }

    /**
     * Generates full models
     */
    private void generateFullModel() {
        // We generate full models for each factory registered
        for(ModelFactory factory : factories) {
            for(int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createFullModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    /**
     * Generates border models
     */
    private void generateBorderModel() {
        // We generate border models for each factory registered
        for(ModelFactory factory : factories) {
            for(int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createBorderModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    /**
     * @return the list of bouncers
     */
    public LinkedList<Bouncable> getBouncers() {
        return bouncers;
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            new BouncerApp().run(); // Démarre le jeu après avoir affiché la fenêtre
        });
    }
}
