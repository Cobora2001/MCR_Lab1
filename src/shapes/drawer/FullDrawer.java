// Authors: Thomas Vuilleumier, Sebastian Diaz

package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

public class FullDrawer extends ModelDrawer {
    private static FullDrawer instance;

    private FullDrawer() {
    }

    public static FullDrawer getInstance() {
        if (instance == null) {
            instance = new FullDrawer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D graphics, Bouncable b) {
        graphics.setColor(b.getColor());
        graphics.fill(b.getShape());
    }
}
