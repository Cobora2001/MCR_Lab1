// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

/**
 * This class is a singleton that draws a bouncable object in full.
 */
public class FullDrawer extends ModelDrawer {
    // Singleton instance
    private static FullDrawer instance;

    // Private constructor
    private FullDrawer() {}

    /**
     * Returns the singleton instance of the FullDrawer.
     * @return the singleton instance of the FullDrawer
     */
    public static FullDrawer getInstance() {
        if (instance == null) {
            instance = new FullDrawer();
        }
        return instance;
    }

    /**
     * Draws a bouncable object in full.
     * @param graphics the graphics object to draw with
     * @param b the bouncable object to draw
     */
    @Override
    public void display(Graphics2D graphics, Bouncable b) {
        graphics.setColor(b.getColor());
        graphics.fill(b.getShape());
    }
}
