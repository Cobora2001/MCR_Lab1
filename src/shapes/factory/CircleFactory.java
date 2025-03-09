package shapes.factory;

import movement.MovementStrategy;
import shapes.Circle;
import shapes.Model;
import shapes.drawer.EmptyDrawer;
import shapes.drawer.FullDrawer;
import shapes.drawer.Renderer;

import java.awt.*;

public class CircleFactory extends ModelFactory {
    private static CircleFactory instance;
    private static final Color fullColor = Color.BLUE;
    private static final Color borderColor = Color.GREEN;

    private CircleFactory() {
    }

    public static CircleFactory getInstance() {
        if (instance == null) {
            instance = new CircleFactory();
        }
        return instance;
    }

    private Model createCircle(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy, Color color, Renderer renderer) {
        int size = randomSize(minSize, maxSize);
        int x = randomX(size);
        int y = randomY(size);
        int speedX = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));
        int speedY = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));

        return new Circle(x, y, size, speedX, speedY, movementStrategy, color, renderer);
    }

    @Override
    public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createCircle(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, fullColor, fullRenderer);
    }

    @Override
    public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createCircle(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, borderColor, borderRenderer);
    }
}
