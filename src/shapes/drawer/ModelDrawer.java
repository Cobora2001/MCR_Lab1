// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

/**
 * This utility class is responsible for drawing shapes.
 */
public abstract class ModelDrawer implements Renderer {
    /**
     * Draws a bouncable object.
     * @param graphics the graphics object to draw with
     * @param b the bouncable object to draw
     */
    @Override
    public abstract void display(Graphics2D graphics, Bouncable b);
}
