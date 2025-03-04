package movement;

import shapes.Shape;

/**
 * This class implements the MovementStrategy interface and provides the logic for the bouncing movement of a shape.
 */
public class BouncingMovement implements MovementStrategy {
    @Override
    public void move(Shape shape, int panelWidth, int panelHeight) {
        shape.setX(shape.getX() + shape.getDx());
        shape.setY(shape.getY() + shape.getDy());

        if (shape.getX() < 0) {
            shape.setX(0);
            shape.setDx(-shape.getDx());
        } else if (shape.getX() + shape.getSize() > panelWidth) {
            shape.setX(panelWidth - shape.getSize());
            shape.setDx(-shape.getDx());
        }

        if (shape.getY() < 0) {
            shape.setY(0);
            shape.setDy(-shape.getDy());
        } else if (shape.getY() + shape.getSize() > panelHeight) {
            shape.setY(panelHeight - shape.getSize());
            shape.setDy(-shape.getDy());
        }
    }

}
