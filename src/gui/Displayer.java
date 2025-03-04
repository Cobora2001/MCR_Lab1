package gui;

import java.awt.*;

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
     * Returns the graphics of the displayer.
     * @return the graphics of the displayer.
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
}
