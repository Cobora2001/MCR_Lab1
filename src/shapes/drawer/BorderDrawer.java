package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

public class BorderDrawer extends ModelDrawer {
    private static BorderDrawer instance;
    private static final int width = 2;

    private BorderDrawer() {
    }

    public static BorderDrawer getInstance() {
        if (instance == null) {
            instance = new BorderDrawer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D graphics, Bouncable b) {
        graphics.setColor(b.getColor());
        graphics.setStroke(new BasicStroke(width));
        graphics.draw(b.getShape());
    }
}
