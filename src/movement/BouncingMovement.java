package movement;

/**
 * This class implements the MovementStrategy interface and provides the logic for the bouncing movement of a shape.
 */
public class BouncingMovement implements MovementStrategy {
    public static BouncingMovement INSTANCE;

    private FieldDimensions dimensions;

    public static BouncingMovement getInstance() {
        if(INSTANCE == null) {
            return INSTANCE = new BouncingMovement();
        }
        return INSTANCE;
    }

    public void setDimensions(FieldDimensions dimensions) {
        this.dimensions = dimensions;
    }

    private BouncingMovement() {
    }

    @Override
    public void move(Movable model) {
        model.setX(model.getX() + model.getDx());
        model.setY(model.getY() + model.getDy());

        if (model.getX() < dimensions.getMinX()) {
            model.setX(0);
            model.setDx(-model.getDx());
        } else if (model.getX() + model.getSize() > dimensions.getMaxX()) {
            model.setX(dimensions.getMaxX() - model.getSize());
            model.setDx(-model.getDx());
        }

        if (model.getY() < dimensions.getMinY()) {
            model.setY(0);
            model.setDy(-model.getDy());
        } else if (model.getY() + model.getSize() > dimensions.getMaxY()) {
            model.setY(dimensions.getMaxY() - model.getSize());
            model.setDy(-model.getDy());
        }
    }
}
