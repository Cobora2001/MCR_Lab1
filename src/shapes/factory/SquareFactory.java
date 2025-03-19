// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.factory;

import movement.MovementStrategy;
import shapes.Model;
import shapes.Square;
import shapes.drawer.Renderer;

import java.awt.*;

/**
 * This class is a singleton that creates squares.
 */
public class SquareFactory extends ModelFactory {
    // Singleton instance
    private static SquareFactory instance;

    // Constants
    private static final Color fullColor = Color.ORANGE;
    private static final Color borderColor = Color.RED;

    // Private constructor
    private SquareFactory() {}

    /**
     * Returns the singleton instance of the SquareFactory.
     * @return the singleton instance of the SquareFactory
     */
    public static SquareFactory getInstance() {
        if (instance == null) {
            instance = new SquareFactory();
        }
        return instance;
    }

    /**
     * Creates a square with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the square
     * @param minAbsSpeed the minimum absolute speed of the square
     * @param maxSize the maximum size of the square
     * @param minSize the minimum size of the square
     * @param movementStrategy the movement strategy of the square
     * @param color the color of the square
     * @param renderer the renderer of the square
     * @return a square with random properties
     */
    private Model createSquare(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy, Color color, Renderer renderer) {
        int size = randomSize(minSize, maxSize);
        int x = randomX(size);
        int y = randomY(size);
        int speedX = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));
        int speedY = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));

        return new Square(x, y, size, speedX, speedY, movementStrategy, color, renderer);
    }

    /**
     * Creates a full square with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the square
     * @param minAbsSpeed the minimum absolute speed of the square
     * @param maxSize the maximum size of the square
     * @param minSize the minimum size of the square
     * @param movementStrategy the movement strategy of the square
     * @return a square with random properties
     */
    @Override
    public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createSquare(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, fullColor, fullRenderer);
    }

    /**
     * Creates a border square with random properties.
     * @param maxAbsSpeed the maximum absolute speed of the square
     * @param minAbsSpeed the minimum absolute speed of the square
     * @param maxSize the maximum size of the square
     * @param minSize the minimum size of the square
     * @param movementStrategy the movement strategy of the square
     * @return a square with random properties
     */
    @Override
    public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createSquare(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, borderColor, borderRenderer);
    }
}
