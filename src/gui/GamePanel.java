package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel implements Displayer {

    private static final int width = 800;
    private static final int height = 600;
    private static GamePanel instance;
    private FieldDimensions fieldDimensions = null;

    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    @Override
    public void repaint() { super.repaint();}
    @Override
    public void setTitle(String title) { MainFrame.getInstance().setTitle(title);}

    @Override
    public void addKeyListener(KeyAdapter ka) {
        super.addKeyListener(ka);
    }

    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
    }

    private GamePanel() {
        super();
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
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
        super.paintComponent(g);

    }
}
