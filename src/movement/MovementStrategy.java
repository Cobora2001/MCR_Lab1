// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

/**
 * This interface provides the method signature for moving a bouncable strategically.
 */
public interface MovementStrategy {
    /**
     * Moves the movable object according to the movement strategy.
     * @param movable the movable object to move
     */
    void move(Movable movable);
}
