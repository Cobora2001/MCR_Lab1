package shapes;

import java.util.Random;

public class ShapeFactory {
    private static final Random random = new Random();

    public static Shape createRandomShape(int width, int height) {
        int size = 20 + random.nextInt(50);
        int x = random.nextInt(width - size);
        int y = random.nextInt(height - size);
        int dx = random.nextInt(5) + 1;
        int dy = random.nextInt(5) + 1;

        if (random.nextBoolean()) {
            return new Circle(x, y, size, dx, dy);
        } else {
            return new Square(x, y, size, dx, dy);
        }
    }
}
