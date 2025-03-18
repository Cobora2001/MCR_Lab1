// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

/**
 * This interface represents a movable object in the game.
 */
public interface Movable {
    // The x and y coordinates of the movable object
    int x = 0;
    int y = 0;
    // The change in x and y coordinates of the movable object
    int dx = 0;
    int dy = 0;
    // The size of the movable object
    int size = 0;

    // Getters and setters
    int getX();
    int getY();
    int getDx();
    int getDy();
    int getSize();

    void setX(int x);
    void setY(int y);
    void setDx(int dx);
    void setDy(int dy);
    void setSize(int size);
}
