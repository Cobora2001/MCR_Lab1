package movement;

import shapes.Shape;

/**
 * This interface provides the method signature for moving a shape strategically.
 */
public interface MovementStrategy {
    /**
     * This method moves the shape according to the movement strategy.
     * @param shape The shape to move
     * @param panelWidth The width of the panel
     * @param panelHeight The height of the panel
     */
    void move(Shape shape, int panelWidth, int panelHeight);
}
