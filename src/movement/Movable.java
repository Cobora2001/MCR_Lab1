// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

/**
 * This interface represents a movable object in the game.
 */
public abstract class Movable {
    // The x and y coordinates of the movable object
    protected int x = 0;
    protected int y = 0;
    // The change in x and y coordinates of the movable object
    protected int dx = 0;
    protected int dy = 0;
    // The size of the movable object
    protected int size = 0;

    // Getters and setters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public int getSize() {
        return size;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
