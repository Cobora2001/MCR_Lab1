package shapes;

import movement.BouncingMovement;

import java.awt.Graphics;
import java.awt.Color;

/**
 * This class represents a square shape bouncing around the screen.
 */
public class Square extends Shape{

    /**
     * Constructor for the Square class.
     * @param x the x-coordinate of the square
     * @param y the y-coordinate of the square
     * @param size the size of the square
     * @param dx the change in x-coordinate of the square (speed)
     * @param dy the change in y-coordinate of the square (speed)
     */
    public Square(int x, int y, int size, int dx, int dy) {
        super(x, y, size, dx, dy, new BouncingMovement());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(),getY(), getSize(), getSize());
    }
}
