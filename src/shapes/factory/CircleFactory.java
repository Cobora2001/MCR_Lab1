// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.factory;

import movement.MovementStrategy;
import shapes.Circle;
import shapes.Model;
import shapes.drawer.Renderer;

import java.awt.*;

/**
 * This class is a singleton that creates circles.
 */
public class CircleFactory extends ModelFactory {
    // Singleton instance
    private static CircleFactory instance;

    // Constants
    private static final Color fullColor = Color.BLUE;
    private static final Color borderColor = Color.GREEN;

    // Private constructor
    private CircleFactory() {}

    /**
     * Returns the singleton instance of the CircleFactory.
     * @return the singleton instance of the CircleFactory
     */
    public static CircleFactory getInstance() {
        if (instance == null) {
            instance = new CircleFactory();
        }
        return instance;
    }

    /**
     * Creates a circle with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the circle
     * @param minAbsSpeed the minimum absolute speed of the circle
     * @param maxSize the maximum size of the circle
     * @param minSize the minimum size of the circle
     * @param movementStrategy the movement strategy of the circle
     * @param color the color of the circle
     * @param renderer the renderer of the circle
     * @return a circle with random properties
     */
    private Model createCircle(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy, Color color, Renderer renderer) {
        int size = randomSize(minSize, maxSize);
        int x = randomX(size);
        int y = randomY(size);
        int speedX = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));
        int speedY = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));

        return new Circle(x, y, size, speedX, speedY, movementStrategy, color, renderer);
    }

    /**
     * Creates a full circle with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the circle
     * @param minAbsSpeed the minimum absolute speed of the circle
     * @param maxSize the maximum size of the circle
     * @param minSize the minimum size of the circle
     * @param movementStrategy the movement strategy of the circle
     * @return a circle with random properties
     */
    @Override
    public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createCircle(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, fullColor, fullRenderer);
    }

    /**
     * Creates a border circle with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the circle
     * @param minAbsSpeed the minimum absolute speed of the circle
     * @param maxSize the maximum size of the circle
     * @param minSize the minimum size of the circle
     * @param movementStrategy the movement strategy of the circle
     * @return a circle with random properties
     */
    @Override
    public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createCircle(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, borderColor, borderRenderer);
    }
}
