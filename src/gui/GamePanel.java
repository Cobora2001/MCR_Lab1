package gui;

import javax.swing.*;
import java.awt.*;

import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel {
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

    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
    }

    private GamePanel() {
        super();
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

    @Override
    public void setPreferredSize(Dimension dimension) {
        super.setPreferredSize(dimension);
    }

    public FieldDimensions getFieldDimensions() {
        return fieldDimensions;
    }
}
