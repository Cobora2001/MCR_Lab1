package gui;

import shapes.Shape;
import shapes.ShapeDrawer;
import shapes.ShapeFactory;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private final List<Shape> shapes = new ArrayList<>();

    public GamePanel(int numShapes, int width, int height, int delay) {
        setPreferredSize(new Dimension(width, height));

        for (int i = 0; i < numShapes; i++) {
            shapes.add(ShapeFactory.createRandomShape(width, height, 5, 1, 40, 10));
        }

        Timer timer = new Timer(delay, e -> {
            for (Shape shape : shapes) {
                shape.move(getWidth(), getHeight());
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            ShapeDrawer.draw(shape, g);
        }
    }
}

