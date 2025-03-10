package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

/**
 * This utility class is responsible for drawing shapes.
 */
public abstract class ModelDrawer implements Renderer {
    @Override
    public abstract void display(Graphics2D graphics, Bouncable b);
}
