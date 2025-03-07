package shapes;

import movement.MovementStrategy;

import java.awt.*;

/**
 * This class represents a square shape bouncing around the screen.
 */
public class Square extends Model {

    /**
     * Constructor for the Square class.
     * @param x the x-coordinate of the square
     * @param y the y-coordinate of the square
     * @param size the size of the square
     * @param dx the change in x-coordinate of the square (speed)
     * @param dy the change in y-coordinate of the square (speed)
     */
    public Square(int x, int y, int size, int dx, int dy, MovementStrategy s, Color color) {
        super(x, y, size, dx, dy, s, color);
    }

    @Override
    public void draw() {
        /*
        g.setColor(Color.BLUE);
        g.fillRect(getX(),getY(), getSize(), getSize());*/
    }

    @Override
    public void move() {

    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
