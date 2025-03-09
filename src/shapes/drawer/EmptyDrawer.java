package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

public class EmptyDrawer extends ModelDrawer {
    private static EmptyDrawer instance;
    private static final int width = 2;

    private EmptyDrawer() {
    }

    public static EmptyDrawer getInstance() {
        if (instance == null) {
            instance = new EmptyDrawer();
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
