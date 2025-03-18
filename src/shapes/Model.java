package shapes;

import gui.GamePanel;
import movement.Movable;
import movement.MovementStrategy;
import shapes.drawer.Renderer;

import java.awt.*;

/**
 * This abstract class represents a shape that can be drawn on the screen.
 */
public abstract class Model implements Bouncable, Movable {
    // Position, size, and speed per frame of the shape
    private int x, y, size, dx, dy;
    // Movement strategy of the shape - this determines how the shape moves
    protected MovementStrategy movementStrategy;
    // Color of the shape
    private Color color;
    // Renderer of the shape
    private Renderer renderer;

    /**
     * Constructor for the Shape class.
     * @param x the x-coordinate of the shape
     * @param y the y-coordinate of the shape
     * @param size the size of the shape
     * @param dx the change in x-coordinate of the shape (speed)
     * @param dy the change in y-coordinate of the shape (speed)
     * @param m the movement strategy of the shape
     */
    public Model(int x, int y, int size, int dx, int dy, MovementStrategy m, Color color, Renderer renderer) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
        this.movementStrategy = m;
        this.color = color;
        this.renderer = renderer;
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
    public Color getColor() {
        return color;
    }
    public abstract Shape getShape();

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

    /**
     * Draws the shape on the screen.
     */
    public void draw() {
        Graphics2D g = GamePanel.getInstance().getGraphics();
        renderer.display(g, this);
    }

    /**
     * Moves the shape on the screen.
     */
    public void move() {
        movementStrategy.move(this);
    }
}
