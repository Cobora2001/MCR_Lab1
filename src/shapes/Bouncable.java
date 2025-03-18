package shapes;

import java.awt.*;

public interface Bouncable {
    /**
     * Draws the bouncable on the screen.
     */
    void draw();

    /**
     * Moves the bouncable on the screen.
     */
    void move();

    /**
     * Returns the color of the bouncable.
     * @return the color of the bouncaable
     */
    Color getColor();

    /**
     * Returns the shape of the bouncable.
     * @return the shape of the bouncable
     */
    Shape getShape();
}
