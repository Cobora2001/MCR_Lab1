// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

/**
 * This utility class is responsible for drawing shapes.
 */
public interface Renderer {
    /**
     * Draws a bouncable object.
     * @param g the graphics object to draw with
     * @param b the bouncable object to draw
     */
    void display(Graphics2D g, Bouncable b);
}