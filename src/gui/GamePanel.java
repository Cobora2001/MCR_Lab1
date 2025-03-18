// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel {
    // Singleton instance
    private static GamePanel instance;

    // Field dimensions
    private FieldDimensions fieldDimensions = null;

    // Buffered image
    private BufferedImage bufferImage;

    /**
     * Private constructor for the GamePanel class.
     */
    private GamePanel() {
        super();
        setFocusable(true);
    }

    /**
     * Initializes the buffer image.
     */
    private void initBuffer() {
        // Get the dimensions of the panel
        int width = getWidth();
        int height = getHeight();

        // Create a new buffered image with the dimensions of the panel if they are positive
        if (width > 0 && height > 0) {
            bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    }

    /**
     * Returns the only instance of GamePanel
     * @return the GamePanel instance
     */
    public static GamePanel getInstance() {
        if (instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }

    /**
     * Paints the component
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(bufferImage == null) {
            initBuffer(); // Initialize the buffer image if it is null
        }

        if(bufferImage != null) {
            g.drawImage(bufferImage, 0, 0, null);
        }
    }

    /**
     * Repaints the component
     */
    public void refresh() {
        repaint();
    }

    /**
     * Returns the buffered image
     * @return the buffered image
     */
    public BufferedImage getBufferImage() {
        if (bufferImage == null || getWidth() != bufferImage.getWidth() || getHeight() != bufferImage.getHeight()) {
            initBuffer();
        }
        return bufferImage;
    }

    /**
     * Sets the field dimensions of the game.
     * @param fieldDimensions the field dimensions of the game
     * Comment: Do not use this to change the field dimensions of the game.
     *          This method is only used to set the field dimensions to be the
     *          same instance as the one used to define the field in the application.
     *          This is to ensure that the field dimensions are the same for all classes.
     */
    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
    }

    /**
     * Returns the field dimensions of the game.
     * @return the field dimensions of the game
     */
    public FieldDimensions getFieldDimensions() {
        return fieldDimensions;
    }
}
