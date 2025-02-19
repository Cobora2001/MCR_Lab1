package movement;

import shapes.Shape;

public interface MovementStrategy {
    void move(Shape shape, int panelWidth, int panelHeight);
}
