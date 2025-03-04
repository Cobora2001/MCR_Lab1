package shapes;

import java.util.Random;

public class ShapeFactory {
    private static final Random random = new Random();

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
