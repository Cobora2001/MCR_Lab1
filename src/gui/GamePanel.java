package gui;

import shapes.Shape;
import shapes.ShapeFactory;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// ne pas le prendre mais avoir un panel qui utilise un run
// c'est une implémentation de ce pannel.
// il faut separer le panel et le run
// le panel doit etre un objet qui est utilisé par le run

public class GamePanel extends JPanel {
    private final List<Shape> shapes = new ArrayList<>();

    public GamePanel(int numShapes) {
        setPreferredSize(new Dimension(800, 600));

        for (int i = 0; i < numShapes; i++) {
            shapes.add(ShapeFactory.createRandomShape(800, 600));
        }

        Timer timer = new Timer(20, e -> {
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
            shape.draw(g);
        }
    }
}

