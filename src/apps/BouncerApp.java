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
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Main Class handling the game logic and the simulation
 */
public class BouncerApp implements App {
    private final int delay = 20;
    private final int maxAbsSpeed = 10;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;
    private final int nbPerGeneration = 10;

    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    private final Vector<ModelFactory> factories = new Vector<>();

    public BouncerApp() {
        MainFrame.getInstance().setTitle("Bouncer App");

        Dimension dimension = MainFrame.getInstance().getPreferredSize();
        FieldDimensions fieldDimensions = new FieldDimensions(0, 0, dimension.width, dimension.height);
        MainFrame.getInstance().setFieldDimensions(fieldDimensions);

        addFactory(CircleFactory.getInstance());
        CircleFactory.getInstance().setFieldDimensions(fieldDimensions);
        addFactory(SquareFactory.getInstance());
        SquareFactory.getInstance().setFieldDimensions(fieldDimensions);
        BouncingMovement.getInstance().setDimensions(fieldDimensions);

        MainFrame.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                treatKeySignal(e);
            }
        });
    }

    public void run() {
        Timer timer = new Timer(delay, e -> updateFrame());
        timer.start();
    }

    private void updateFrame() {
        BufferedImage buffer = GamePanel.getInstance().getBufferImage();
        Graphics2D g2 = buffer.createGraphics();

        // Efface l’image tampon pour éviter le traînage des images précédentes
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

        // Déplacement des objets avant de les dessiner
        for (Bouncable b : bouncers) {
            b.move(); // Déplace chaque bouncer
        }

        draw();

        g2.dispose(); // Libère les ressources graphiques

        // Demande à GamePanel de rafraîchir l’affichage
        GamePanel.getInstance().refresh();
    }

    /**
     * Is used to draw specific elements from the App on a Graphics object
     */
    @Override
    public void draw() {
        for (Bouncable bouncable : bouncers) {
            bouncable.draw();
        }
    }


    private void clearBouncers() {
        bouncers.clear();
    }

    private void quit() {
        System.exit(0);
    }

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

    public void addFactory(ModelFactory factory) {
        factories.add(factory);
    }

    private void generateFullModel() {
        for (ModelFactory factory : factories) {
            for (int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createFullModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    private void generateBorderModel() {
        for (ModelFactory factory : factories) {
            for (int i = 0; i < nbPerGeneration; ++i) {
                bouncers.add(factory.createBorderModel(maxAbsSpeed, minAbsSpeed, maxSize, minSize, BouncingMovement.getInstance()));
            }
        }
    }

    public LinkedList<Bouncable> getBouncers() {
        return bouncers;
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> new BouncerApp().run());
    }
}
