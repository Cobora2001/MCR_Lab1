// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import javax.swing.*;
import java.awt.*;

import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel {
    // Singleton pattern instance
    private static GamePanel instance;

    // Field dimensions of the panel
    // This is used to keep track of the dimensions of the panel, and keep it coherent
    // with other parts of the application that use the same instance of FieldDimensions
    // As such, when the panel is resized, the dimensions of this object should be updated
    private FieldDimensions fieldDimensions = null;

    /**
     * Paints the component
     * @param g the graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Sets the preferred size of the panel
     * @param dimension the dimension to set
     */
    @Override
    public void setPreferredSize(Dimension dimension) {
        super.setPreferredSize(dimension);
    }

    /**
     * Sets the field dimensions of the panel
     * @param fieldDimensions the field dimensions to set
     * Comment: This method should only be used once, when the field dimensions are set
     *          for the first time. It should not be used to update the field dimensions,
     *          as it would change the reference of the fieldDimensions object, and other
     *          parts of the application that use the same instance would not be updated.
     */
    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
    }

    // Getters section
    public FieldDimensions getFieldDimensions() {
        return fieldDimensions;
    }
    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
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

    /**
     * Repaints the panel
     */
    @Override
    public void repaint() { super.repaint();}

    /**
     * Private constructor for the GamePanel class, to implement the Singleton pattern
     */
    private GamePanel() {
        super();
        setFocusable(true);
    }
}
