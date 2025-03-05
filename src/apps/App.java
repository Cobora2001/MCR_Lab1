package apps;

import java.awt.*;

public interface App {
    /**
     * Is used to draw specific elements from the App on a Graphics object
     * @param g the Graphics object to draw on
     */
    public void draw(Graphics g);
}
