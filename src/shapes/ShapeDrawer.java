package shapes;

import java.awt.*;

public class ShapeDrawer {
    public static void draw(Shape shape, Graphics g) {
        switch (shape.getClass().getSimpleName()) {
            case "Square":
                ((Square) shape).draw(g);
                break;
            case "Circle":
                ((Circle) shape).draw(g);
                break;
            default:
                shape.draw(g);
                break;
        }
    }

}
