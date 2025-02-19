package movement;

import shapes.Shape;

public class BouncingMovement implements MovementStrategy {
    @Override
    public void move(Shape shape, int panelWidth, int panelHeight) {
        shape.setX(shape.getX() + shape.getDx());
        shape.setY(shape.getY() + shape.getDy());

        // Collision avec le bords droite et gauche (si gauche, vitesse négative, si droite, vitesse positive)
        if (shape.getX() < 0) {
            if(shape.getDx() < 0) {
                shape.setDx(-shape.getDx());
            }
        } else if (shape.getX() + shape.getSize() > panelWidth) {
            if(shape.getDx() > 0) {
                shape.setDx(-shape.getDx());
            }
        }

        // Collision avec le bords haut et bas (si haut, vitesse négative, si bas, vitesse positive)
        if(shape.getY() < 0) {
            if(shape.getDy() < 0) {
                shape.setDy(-shape.getDy());
            }
        } else if (shape.getY() + shape.getSize() > panelHeight) {
            if(shape.getDy() > 0) {
                shape.setDy(-shape.getDy());
            }
        }
    }

    //à changer car la vitesse de deplacement est la même ainsi que la redirection
}
