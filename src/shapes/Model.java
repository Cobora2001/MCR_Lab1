package shapes;

import movement.Movable;
import movement.MovementStrategy;

import java.awt.*;

/**
 * This abstract class represents a shape that can be drawn on the screen.
 */
public abstract class Model implements Bouncable, Movable {
    private int x, y, size, dx, dy;
    protected MovementStrategy movementStrategy;
    private Color color;

    /**
     * Constructor for the Shape class.
     * @param x the x-coordinate of the shape
     * @param y the y-coordinate of the shape
     * @param size the size of the shape
     * @param dx the change in x-coordinate of the shape (speed)
     * @param dy the change in y-coordinate of the shape (speed)
     * @param m the movement strategy of the shape
     */
    public Model(int x, int y, int size, int dx, int dy, MovementStrategy m, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
        this.movementStrategy = m;
        this.color = color;
    }

    /**
     * Moves the shape on the screen.
     * @param width the space available to move in the x-direction
     * @param height the space available to move in the y-direction
     */
    public void move(int width, int height) {
        movementStrategy.move(this);
    }

    // Getters section
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSize() {
        return size;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    // Setters section
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }

    // Abstract methods from Bouncable
    public abstract void draw();
    public abstract void move();
    public abstract Color getColor();
    public abstract Shape getShape();
}
