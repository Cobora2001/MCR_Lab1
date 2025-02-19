package shapes;

import java.util.Random;

public class ShapeFactory {
    private static final Random random = new Random();

    public static Shape createRandomShape(int width, int height, int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize) {
        int size = random.nextInt(maxSize - minSize) + minSize;
        int x = random.nextInt(width - size);
        int y = random.nextInt(height - size);
        int dx = random.nextInt(maxAbsSpeed - minAbsSpeed) + minAbsSpeed;
        int dy = random.nextInt(maxAbsSpeed - minAbsSpeed) + minAbsSpeed;

        // Autorise des dx et dy négatifs
        if (random.nextBoolean()) {
            dx = -dx;
        }
        if (random.nextBoolean()) {
            dy = -dy;
        }

        if (random.nextBoolean()) {
            return new Circle(x, y, size, dx, dy);
        } else {
            return new Square(x, y, size, dx, dy);
        }
    }
}
