package gui;

import javax.swing.*;
import java.awt.*;
import shapes.Shape;
import main.BouncerApp;
import shapes.ShapeDrawer;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel implements Displayer {

    private static final int width = 800;
    private static final int height = 600;
    private static GamePanel instance;

    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {
        // ⚠️ Do not use this method to draw shapes, use repaint instead!!!
        return (Graphics2D) super.getGraphics(); // Cast valid because we use a JPanel
    }

    @Override
    public void repaint() { super.repaint();}
    @Override
    public void setTitle(String title) { MainFrame.getInstance().setTitle(title);}

    private GamePanel() {
        super();
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * Returns the only instance of GamePanel
     * @return the GamePanel instance
     */
    public static GamePanel getInstance() {
        if(instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //the shapes are drawn using repaint
        super.paintComponent(g);
        for(Shape shape : BouncerApp.getBouncers()){
            ShapeDrawer.draw(shape, g);
        }
    }

}
