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
    protected static final Renderer fullRenderer = FullDrawer.getInstance();
    protected static final Renderer borderRenderer = BorderDrawer.getInstance();

    private final Random random = new Random();

    private FieldDimensions dimensions;

    private void checkDimensionValidity() {
        if (dimensions == null || ! dimensions.dimensionsValid()) {
            throw new IllegalArgumentException("Invalid arguments for ModelFactory");
        }
    }

    public void setFieldDimensions(FieldDimensions dimensions) {
        this.dimensions = dimensions;
        checkDimensionValidity();
    }

    /**
     * Creates a random shape with random properties
     * @param maxAbsSpeed the maximum absolute speed of the shape
     * @param minAbsSpeed the minimum absolute speed of the shape
     * @param maxSize the maximum size of the shape
     * @param minSize the minimum size of the shape
     * @return an instance of circle or square with random properties
     * @throws IllegalArgumentException if the arguments are invalid
     */
    abstract public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy);
    abstract public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy);

    protected int randomSize(int minSize, int maxSize) {
        return random.nextInt(maxSize - minSize) + minSize;
    }

    protected int randomX(int size) {
        return dimensions.getMinX() + random.nextInt((dimensions.getMaxX() - dimensions.getMinX()) - size);
    }

    protected int randomY(int size) {
        return dimensions.getMinY() + random.nextInt((dimensions.getMaxY() - dimensions.getMinY()) - size);
    }

    protected int randomSpeed(int minAbsSpeed, int maxAbsSpeed) {
        return minAbsSpeed + random.nextInt(maxAbsSpeed - minAbsSpeed);
    }

    protected int randomDirection(int speed) {
        if(random.nextBoolean()) {
            return -speed;
        }
        return speed;
    }
}
