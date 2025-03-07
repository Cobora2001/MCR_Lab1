package apps;

import gui.MainFrame;
import gui.GamePanel;
import movement.BouncingMovement;
import movement.FieldDimensions;
import shapes.Bouncable;
import shapes.factory.CircleFactory;
import shapes.factory.ModelFactory;
import shapes.factory.SquareFactory;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Main Class handling the game logic and the simulation
 */
public class BouncerApp implements App {
    private final int delay = 20;

    private final int maxAbsSpeed = 5;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;

    private final int nbPerGeneration = 10;

    private FieldDimensions fieldDimensions = null;

    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    private final Vector<ModelFactory> factories = new Vector<>();

    /**
     * Constructor of the BouncerApp class
     * Initializes the bouncers and adds them to the GamePanel
     */
    public BouncerApp() {
        GamePanel.getInstance();

        Dimension dimension = GamePanel.getInstance().getPreferredSize();

        fieldDimensions = new FieldDimensions(0, 0, dimension.width, dimension.height);

        addFactory(CircleFactory.getInstance());

        CircleFactory.getInstance().setFieldDimensions(fieldDimensions);

        addFactory(SquareFactory.getInstance());

        SquareFactory.getInstance().setFieldDimensions(fieldDimensions);



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
        GamePanel.getInstance().setApp(this);
        Timer timer = new Timer(delay, e -> {
            for (Bouncable bouncable : bouncers) {
                bouncable.move();
            }

            GamePanel.getInstance().repaint();
        });
        timer.start();
    }

    /**
     * Is used to draw specific elements from the App on a Graphics object
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        for (Bouncable bouncable : bouncers) {
            bouncable.draw();
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
            MainFrame.getInstance().setTitle("Bouncer App");
            new BouncerApp().run(); // Démarre le jeu après avoir affiché la fenêtre
        });
    }

    public void addFactory(ModelFactory factory) {
        factories.add(factory);
    }

    private void generateFullModel() {
        for(ModelFactory factory : factories) {
            for(int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createFullModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    private void generateBorderModel() {
        for(ModelFactory factory : factories) {
            for(int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createBorderModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }
}
