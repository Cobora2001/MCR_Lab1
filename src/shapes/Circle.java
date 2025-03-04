package shapes;

import movement.BouncingMovement;

import java.awt.Graphics;
import java.awt.Color;

/**
 * This class represents a circle shape bouncing around the screen.
 */
public class Circle extends Shape {

    /**
     * Constructor for the Circle class.
     * @param x the x-coordinate of the circle
     * @param y the y-coordinate of the circle
     * @param size the size of the circle
     * @param dx the change in x-coordinate of the circle (speed)
     * @param dy the change in y-coordinate of the circle (speed)
     */
    public Circle(int x, int y, int size, int dx, int dy) {
        super(x, y, size, dx, dy, new BouncingMovement());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), getSize(), getSize());
    }
}
