package shapes.factory;

import movement.MovementStrategy;
import shapes.Model;
import shapes.Square;
import shapes.drawer.Renderer;

import java.awt.*;

public class SquareFactory extends ModelFactory {
    private static SquareFactory instance;
    private static final Color fullColor = Color.ORANGE;
    private static final Color borderColor = Color.RED;

    private SquareFactory() {
    }

    public static SquareFactory getInstance() {
        if (instance == null) {
            instance = new SquareFactory();
        }
        return instance;
    }

    private Model createSquare(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy, Color color, Renderer renderer) {
        int size = randomSize(minSize, maxSize);
        int x = randomX(size);
        int y = randomY(size);
        int speedX = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));
        int speedY = randomDirection(randomSpeed(minAbsSpeed, maxAbsSpeed));

        return new Square(x, y, size, speedX, speedY, movementStrategy, color, renderer);
    }

    @Override
    public Model createFullModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createSquare(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, fullColor, fullRenderer);
    }

    @Override
    public Model createBorderModel(int maxAbsSpeed, int minAbsSpeed, int maxSize, int minSize, MovementStrategy movementStrategy) {
        return createSquare(maxAbsSpeed, minAbsSpeed, maxSize, minSize, movementStrategy, borderColor, borderRenderer);
    }
}
