package movement;

import shapes.Shape;

public class BouncingMovement implements MovementStrategy {
    @Override
    public void move(Shape shape, int panelWidth, int panelHeight) {
        shape.setX(shape.getX() + shape.getDx());
        shape.setY(shape.getY() + shape.getDy());

        // Collision avec le bords gauche et droit
        if (shape.getX() < 0 || shape.getX() + shape.getSize() > panelWidth) {
            shape.setDx(-shape.getDx());
        }

        // Collision avec le bords haut et bas
        if (shape.getY() < 0 || shape.getY() + shape.getSize() > panelHeight) {
            shape.setDy(-shape.getDy());
        }
    }

    //à changer car la vitesse de deplacement est la même ainsi que la redirection
}
