// Authors: Thomas Vuilleumier, Sebastian Diaz

package movement;

import java.awt.*;

/**
 * This class represents the dimensions of the field in which the game is played.
 */
public class FieldDimensions {
    // Singleton instance of the FieldDimensions class
    private static FieldDimensions instance;

    // The minimum and maximum x and y coordinates of the field
    private int minX = 0;
    private int minY = 0;
    private int maxX = 0;
    private int maxY = 0;

    /**
     * Returns the singleton instance of the FieldDimensions class.
     * @return the singleton instance of the FieldDimensions class
     */
    public static FieldDimensions getInstance() {
        if (instance == null) {
            return instance = new FieldDimensions();
        }
        return instance;
    }

    // Getters and setters
    public int getMinX() {
        return minX;
    }
    public void setMinX(int minX) {
        this.minX = minX;
    }
    public int getMinY() {
        return minY;
    }
    public void setMinY(int minY) {
        this.minY = minY;
    }
    public int getMaxX() {
        return maxX;
    }
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
    public int getMaxY() {
        return maxY;
    }
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    /**
     * Constuctor of the FieldDimensions
     * @param minX minimum x coordinate
     * @param minY minimum y coordinate
     * @param maxX maximum x coordinate
     * @param maxY maximum y coordinate
     */
    private FieldDimensions(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Default constructor of the FieldDimensions
     */
    private FieldDimensions() {
        this(0, 0, 0, 0);
    }

    /**
     * Checks if the dimensions of the field are valid.
     * @return true if the dimensions are valid, false otherwise
     */
    public boolean dimensionsValid() {
        return minX <= maxX && minY <= maxY;
    }

    /**
     * Returns the bounds of the field.
     * @return the bounds of the field
     */
    public Rectangle getBounds() {
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
}
