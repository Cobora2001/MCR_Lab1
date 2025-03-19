// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * Interface defining the methods that a displayer should have.
 */
public interface Displayer {
    /**
     * Returns the width of the displayer.
     * @return the width of the displayer.
     */
    int getWidth();

    /**
     * Returns the height of the displayer.
     * @return the height of the displayer.
     */
    int getHeight();

    /**
     * @return the image of the graphic that we want to change and display.
     */
    Graphics2D getGraphics();

    /**
     * Repaints the displayer.
     */
    void repaint();

    /**
     * Sets the title of the displayer.
     * @param title the title to set.
     */
    void setTitle(String title);

    /**
     * Allows us to add a key listener to the displayer.
     * @param ka the key listener to add.
     */
    void addKeyListener(KeyAdapter ka);
}
