// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

/**
 * This class implements the MovementStrategy interface and provides the logic
 * for the bouncing movement of a movable object.
 */
public class BouncingMovement implements MovementStrategy {

    // Singleton instance of the BouncingMovement class
    public static BouncingMovement INSTANCE;

    // Field dimensions of the game - must be the same instance as the one used to define the field
    // in the application
    private FieldDimensions dimensions;

    /**
     * Returns the singleton instance of the BouncingMovement class.
     * @return the singleton instance of the BouncingMovement class
     */
    public static BouncingMovement getInstance() {
        if(INSTANCE == null) {
            return INSTANCE = new BouncingMovement();
        }
        return INSTANCE;
    }

    /**
     * Sets the field dimensions of the game.
     * @param dimensions the field dimensions of the game
     */
    public void setDimensions(FieldDimensions dimensions) {
        this.dimensions = dimensions;
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

        if (model.getX() < dimensions.getMinX()) {
            model.setX(dimensions.getMinX());
            model.setDx(-model.getDx());
        } else if (model.getX() + model.getSize() > dimensions.getMaxX()) {
            model.setX(dimensions.getMaxX() - model.getSize());
            model.setDx(-model.getDx());
        }

        if (model.getY() < dimensions.getMinY()) {
            model.setY(dimensions.getMinY());
            model.setDy(-model.getDy());
        } else if (model.getY() + model.getSize() > dimensions.getMaxY()) {
            model.setY(dimensions.getMaxY() - model.getSize());
            model.setDy(-model.getDy());
        }
    }
}
