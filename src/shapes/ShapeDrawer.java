package shapes;

import java.awt.*;

/**
 * This utility class is responsible for drawing shapes.
 */
public class ShapeDrawer {

    /**
     * Draws the shape using the given graphics object.
     * @param shape the shape to draw
     * @param g the context to draw the shape
     */
    public static void draw(Shape shape, Graphics g) {
        shape.draw(g);
    }
}
