// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

/**
 * This class is a singleton that draws the border of a bouncable object.
 */
public class BorderDrawer extends ModelDrawer {
    // Singleton instance
    private static BorderDrawer instance;

    // Width of the border
    private static final int width = 2;

    // Private constructor
    private BorderDrawer() {
    }

    /**
     * Returns the singleton instance of the BorderDrawer.
     * @return the singleton instance of the BorderDrawer
     */
    public static BorderDrawer getInstance() {
        if (instance == null) {
            instance = new BorderDrawer();
        }
        return instance;
    }

    /**
     * Draws the border of a bouncable object.
     * @param graphics the graphics object to draw with
     * @param b the bouncable object to draw
     */
    @Override
    public void display(Graphics2D graphics, Bouncable b) {
        graphics.setColor(b.getColor());
        graphics.setStroke(new BasicStroke(width));
        graphics.draw(b.getShape());
    }
}
