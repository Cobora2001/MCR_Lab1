package shapes.drawer;

import shapes.Bouncable;

import java.awt.*;

public interface Renderer {
    void display(Graphics2D g, Bouncable b);
}