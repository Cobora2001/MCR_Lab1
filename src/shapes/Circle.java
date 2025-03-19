// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes;

import movement.MovementStrategy;
import shapes.drawer.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class represents a circle shape bouncing around the screen.
 */
public class Circle extends Model {

    /**
     * Constructor for the Circle class.
     * @param x the x-coordinate of the circle
     * @param y the y-coordinate of the circle
     * @param size the size of the circle
     * @param dx the change in x-coordinate of the circle (speed)
     * @param dy the change in y-coordinate of the circle (speed)
     */
    public Circle(int x, int y, int size, int dx, int dy, MovementStrategy s, Color color, Renderer renderer) {
        super(x, y, size, dx, dy, s, color, renderer);
    }

    /**
     * Returns the shape of the circle
     * @return the shape of the circle
     */
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }
}
