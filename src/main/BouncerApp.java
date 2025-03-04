package main;

import gui.MainFrame;
import shapes.Shape;

import java.awt.*;
import java.util.LinkedList;
import shapes.ShapeFactory;
import gui.GamePanel;

import javax.swing.*;

public class BouncerApp {
    private final int nbOfShapes = 50;
    private final int delay = 20;

    private final int maxAbsSpeed = 5;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;

    private static final LinkedList<Shape> bouncers = new LinkedList<>();

    public BouncerApp() {
        GamePanel.getInstance();

        Dimension dimension = GamePanel.getInstance().getPreferredSize();

        for (int i = 0; i < nbOfShapes; i++) {
            bouncers.add(ShapeFactory.createRandomShape(dimension.width,
                    dimension.height, maxAbsSpeed, minAbsSpeed, maxSize, minSize));
        }

        AddBouncersToGamePanel();
    }

    private void AddBouncersToGamePanel() {
        GamePanel.getInstance().repaint();
    }

    public void run(){
        Timer timer = new Timer(delay, e -> {
            for (Shape shape : bouncers) {
                shape.move(GamePanel.getInstance().getWidth(), GamePanel.getInstance().getHeight());
            }

            GamePanel.getInstance().repaint();
        });
        timer.start();
    }

    public static LinkedList<Shape> getBouncers() {
        return bouncers;
    }

    public static void main(String... args){
        SwingUtilities.invokeLater(MainFrame::getInstance);
        GamePanel.getInstance().setTitle("Bouncer App");

        new BouncerApp().run();
    }
}

