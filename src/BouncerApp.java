import shapes.Shape;

import java.awt.*;
import java.util.LinkedList;
import shapes.ShapeDrawer;
import shapes.ShapeFactory;
import gui.GamePanel;

import javax.swing.*;

public class BouncerApp {

    private static final int width = 800;
    private static final int height = 600;

    private final int nbOfShapes = 50;
    private final int delay = 20;

    private final int maxAbsSpeed = 5;
    private final int minAbsSpeed = 1;
    private final int maxSize = 40;
    private final int minSize = 10;

    private final LinkedList<Shape> bouncers = new LinkedList<>();

    public BouncerApp() {
        // devrait appeller la factory pour remplir la liste non???
        GamePanel.getInstance().setPreferredSize(width, height);

        Dimension dimension = GamePanel.getInstance().getPreferredSize();

        for (int i = 0; i < nbOfShapes; i++) {
            bouncers.add(ShapeFactory.createRandomShape(dimension.width,
                    dimension.height, maxAbsSpeed, minAbsSpeed, maxSize, minSize));
        }
/*

//

*/

        //TODO
    }

    public void run(){
        Timer timer = new Timer(delay, e -> {
            for (Shape shape : bouncers) {
                shape.move(GamePanel.getInstance().getWidth(), GamePanel.getInstance().getHeight());
            }

            GamePanel.getInstance().repaint();

            for( Shape shape : bouncers){
                ShapeDrawer.draw(shape, GamePanel.getInstance().getGraphics());
            }
        });
        timer.start();
    }

    public static void main(String... args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(GamePanel.getInstance());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        GamePanel.getInstance().setTitle("Bouncer App");
        GamePanel.getInstance().setPreferredSize(width, height);

        new BouncerApp().run();
    }
}

