// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.factory;

import movement.FieldDimensions;
import movement.MovementStrategy;
import shapes.Model;
import shapes.drawer.BorderDrawer;
import shapes.drawer.FullDrawer;
import shapes.drawer.Renderer;

import java.util.Random;

/**
 * This class is a factory for creating random shapes.
 */
abstract public class ModelFactory {
    // Constant renderers
    protected static final Renderer fullRenderer = FullDrawer.getInstance();
    protected static final Renderer borderRenderer = BorderDrawer.getInstance();

    // Random number generator
    private final Random random = new Random();

    /**
     * Checks if the field dimensions are valid.
     * @throws IllegalArgumentException if the field dimensions are invalid
     */
    private void checkDimensionValidity() {
        if(FieldDimensions.getInstance().dimensionsValid()) {
            throw new IllegalArgumentException("Invalid arguments for ModelFactory");
        }
    }

    /**
     * Creates a full shape with random properties
     * @param maxAbsSpeed the maximum absolute speed of the shape
     * @param minAbsSpeed the minimum absolute speed of the shape
     * @param maxSize the maximum size of the shape
     * @param minSize the minimum size of the shape
     * @return an instance of circle or square with random properties
     * @throws IllegalArgumentException if the arguments are invalid
     */
    abstract public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy);

    /**
     * Creates a border shape with random properties
     * @param maxAbsSpeed the maximum absolute speed of the shape
     * @param minAbsSpeed the minimum absolute speed of the shape
     * @param maxSize the maximum size of the shape
     * @param minSize the minimum size of the shape
     * @return an instance of circle or square with random properties
     * @throws IllegalArgumentException if the arguments are invalid
     */
    abstract public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy);

    /**
     * Generates a random size
     * @param minSize the minimum size
     * @param maxSize the maximum size
     * @return a random size
     */
    protected int randomSize(int minSize, int maxSize) {
        return random.nextInt(maxSize - minSize) + minSize;
    }

    /**
     * Generates a random x coordinate
     * @param size the size of the shape
     * @return a random x coordinate
     */
    protected int randomX(int size) {
        return FieldDimensions.getInstance().getMinX() + random.nextInt((FieldDimensions.getInstance().getMaxX() - FieldDimensions.getInstance().getMinX()) - size);
    }

    /**
     * Generates a random y coordinate
     * @param size the size of the shape
     * @return a random y coordinate
     */
    protected int randomY(int size) {
        return FieldDimensions.getInstance().getMinY() + random.nextInt((FieldDimensions.getInstance().getMaxY() - FieldDimensions.getInstance().getMinY()) - size);
    }

    /**
     * Generates a random speed
     * @param minAbsSpeed the minimum absolute speed
     * @param maxAbsSpeed the maximum absolute speed
     * @return a random speed
     */
    protected int randomSpeed(int minAbsSpeed, int maxAbsSpeed) {
        return minAbsSpeed + random.nextInt(maxAbsSpeed - minAbsSpeed);
    }

    /**
     * Generates a random direction for the speed
     * @param speed the speed to which we should apply the direction
     * @return a speed with a random direction
     */
    protected int randomDirection(int speed) {
        if(random.nextBoolean()) {
            return -speed;
        }
        return speed;
    }
}
