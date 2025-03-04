package shapes;

import java.util.Random;

/**
 * This class is a factory for creating random shapes.
 */
public class ShapeFactory {
    private static final Random random = new Random();

    /**
     * Creates a random shape with random properties
     * @param width the width of the panel
     * @param height the height of the panel
     * @param maxAbsSpeed the maximum absolute speed of the shape
     * @param minAbsSpeed the minimum absolute speed of the shape
     * @param maxSize the maximum size of the shape
     * @param minSize the minimum size of the shape
     * @return an instance of circle or square with random properties
     * @throws IllegalArgumentException if the arguments are invalid
     */
    public static Shape createRandomShape(int width, int height, int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize) {
        if (maxSize <= 0 || minSize <= 0 || maxAbsSpeed <= 0 || minAbsSpeed <= 0 || maxSize < minSize || maxAbsSpeed < minAbsSpeed) {
            throw new IllegalArgumentException("Invalid arguments for ShapeFactory");
        }

        int size = random.nextInt(maxSize - minSize) + minSize;
        int x = random.nextInt(width - size);
        int y = random.nextInt(height - size);
        int dx = random.nextInt(maxAbsSpeed - minAbsSpeed) + minAbsSpeed;
        int dy = random.nextInt(maxAbsSpeed - minAbsSpeed) + minAbsSpeed;

        if (random.nextBoolean()) {
            dx = -dx;
        }
        if (random.nextBoolean()) {
            dy = -dy;
        }

        return random.nextBoolean() ? new Circle(x, y, size, dx, dy) : new Square(x, y, size, dx, dy);
    }
}
