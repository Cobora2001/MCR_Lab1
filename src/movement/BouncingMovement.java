// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

/**
 * This class implements the MovementStrategy interface and provides the logic
 * for the bouncing movement of a movable object.
 */
public class BouncingMovement implements MovementStrategy {

    // Singleton instance of the BouncingMovement class
    private static BouncingMovement instance;

    /**
     * Returns the singleton instance of the BouncingMovement class.
     * @return the singleton instance of the BouncingMovement class
     */
    public static BouncingMovement getInstance() {
        if(instance == null) {
            return instance = new BouncingMovement();
        }
        return instance;
    }

    /**
     * Private constructor for the BouncingMovement class.
     */
    private BouncingMovement() {}

    /**
     * Moves the movable object according to the bouncing movement strategy.
     * @param model the movable object to move
     */
    @Override
    public void move(Movable model) {
        model.setX(model.getX() + model.getDx());
        model.setY(model.getY() + model.getDy());

        // Check if the object has reached the borders of the field
        if (model.getX() < FieldDimensions.getInstance().getMinX()) {
            model.setX(FieldDimensions.getInstance().getMinX());
            model.setDx(-model.getDx());
        } else if (model.getX() + model.getSize() > FieldDimensions.getInstance().getMaxX()) {
            model.setX(FieldDimensions.getInstance().getMaxX() - model.getSize());
            model.setDx(-model.getDx());
        }

        // Check if the object has reached the borders of the field
        if (model.getY() < FieldDimensions.getInstance().getMinY()) {
            model.setY(FieldDimensions.getInstance().getMinY());
            model.setDy(-model.getDy());
        } else if (model.getY() + model.getSize() > FieldDimensions.getInstance().getMaxY()) {
            model.setY(FieldDimensions.getInstance().getMaxY() - model.getSize());
            model.setDy(-model.getDy());
        }
    }
}
